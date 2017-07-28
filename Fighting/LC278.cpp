/*
278. First Bad Version

You are a product manager and currently leading a team to develop a new product. 
Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. 
You should minimize the number of calls to the API.
*/

#include<iostream>

using namespace std;

class LC278{
public:
	// Time Compelxity: O(logN)
	// Runtime: 0ms, beats 28.58%
	int firstBadVersion(int n){
		if(n == 1)
			return 1;

		int start = 1, end = n;
		// Corner case: 2 versions, 1 is the first version
		// If use start <= end, it will go into the infinite loop
		while(start < end){
			int mid = start + (end - start) / 2;
			if(!isBadVersion(mid))
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}


	// Time Limit Exceed...
	int firstBadVersion2(int n){
		if(n == 1)
			return 1;

		int start = 1, end = n;
		

		while(start <= end){
			int mid = start + (end - start) / 2;
			if(isBadVersion(mid) && !isBadVersion(mid - 1))
				return mid;
			else if(isBadVersion(mid) && isBadVersion(mid - 1))
				end = mid - 1;
			else if(!isBadVersion(mid))
				start = end;
		}
		return mid;
	}

	bool isBadVersion(int version){

	}
};
