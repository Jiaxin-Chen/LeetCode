/*
281. Zigzag Iterator

Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
*/

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

// Time Complexity: O(N)
// Runtime: 22ms, beats 42.68%
class LC281{
public:

	queue<pair<vector<int>::iterator, vector<int>::iterator>> q;

	LC281(vector<int>& v1, vector<int>& v2){
		if(v1.size() != 0)
			q.push(make_pair(v1.begin(), v1.end()));
		if(v2.size() != 0)
			q.push(make_pair(v2.begin(), v2.end()));
	}

	int next(){
		vector<int>::iterator beginIter = q.front().first;
		vector<int>::iterator endIter = q.front().second;
		q.pop();
		// because endIter actually is the pointer to the last element's next.
		if(beginIter + 1 != endIter)  
			q.push(make_pair(beginIter + 1, endIter));
		return *beginIter;
	}

	bool hasNext(){
		return !q.empty();
	}


	// My version:
	// Runtime error......
/*	vector<int> nums;
	int index;

	LC281(vector<int>& v1, vector<int>& v2){
		int len1 = v1.size(), len2 = v2.size();
		if(len1 == 0)
			nums = v2;
		if(len2 == 0)
			nums = v1;

		int i = 0, j = 0;
		while ((i < len1) && (j < len2)){
			nums.push_back(v1[i++]);
			nums.push_back(v2[j++]);
		}

		if(i == len1){
			while(j < len2)
				nums.push_back(v2[j++]);
		}
		else if(j == len2){
			while(i < len1)
				nums.push_back(v1[i++]);
		}
	}

	int next(){
		return nums[index++];
	}

	bool hasNext(){
		return index != nums.size();
	}
	*/
};

int main(){
	vector<int> v1 = {1, 2};
	vector<int> v2 = {4, 5, 6, 7};
	LC281 i(v1, v2);

//	for(auto& num : nums)
//		cout << num << endl;

	while(i.hasNext())
		cout << i.next() << endl;
	return 0;
}

