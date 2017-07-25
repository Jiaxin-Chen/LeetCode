/*
275. H-Index II

Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */

#include<iostream>
#include<vector>

using namespace std;

class LC275{
public: 
	// Time Complexity: O(n)
	// Runtime: 6ms, beats 66.47%
	int hIndex(vector<int>& citations){
		int left = 0, n = citations.size();
		int right = n - 1, mid = 0;

		while(left <= right){
			mid = left + (right - left) / 2;
			// there are citations[mid] papers that have at least citations[mid] citations.
			if(citations[mid] == (n - mid))
				return citations[mid];
			// citations[mid] papers that have moret than citations[mid] citations, 
			// so we should continue searching in the left half
			else if(citations[mid] > (n - mid))
				right = mid - 1;
			else
				left = mid + 1;
		}
		return n - left;
	}
};

int main(){
	LC275 *x = new LC275();
	vector<int> citations = {3, 0, 6, 1, 5};
	cout << x->hIndex(citations) << endl;

	return 0;
}