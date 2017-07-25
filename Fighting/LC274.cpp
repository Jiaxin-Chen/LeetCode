/*
274. H-Index

Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, 
and the other N − h papers have no more than h citations each."

For example, 
given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. 
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: 
If there are several possible values for h, the maximum one is taken as the h-index.
 */

#include<iostream>
#include<vector>

using namespace std;

class LC274{
public:
	// Bucket sort
	// Time Complexity: O(n)
	// Runtime: 3ms, beats 19.68%
	int hIndex(vector<int>& citations){
		if(citations.size() == 0)
			return 0;

		int n = citations.size();
		vector<int> buckets(n + 1, 0); // We need initialize the buckets here, so it's better to use vector rather than array!
		int count = 0;

		for(int i = 0; i < n; i++){
			if(citations[i] >= n)
				buckets[n]++;
			else
				buckets[citations[i]]++;
		}

		for(int i = 0; i < n+1; i++)
			cout << buckets[i] << endl;

		for(int i = n; i >= 0; i--){
			count += buckets[i];
			if(count >= i)
				return i;
		}
		return 0;
	}
};

int main(){
	LC274 *x = new LC274();
	vector<int> citations = {3, 0, 6, 1, 5};
	cout << x->hIndex(citations) << endl;

	return 0;
}