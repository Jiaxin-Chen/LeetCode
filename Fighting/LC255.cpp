/*
255. Verify Preorder Sequence in Binary Search Tree

Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
 */

#include<iostream>
#include<vector>
#include<stack>    //stack
#include<climits>  // INT_MIN, INT_MAX

using namespace std;

class LC255{
public:
	// Time Complexity: O(N)
	// Runtime: 49ms, beats 46.67%
	bool verifyPreorder(vector<int>& preorder){
		if(preorder.size() < 2)
			return true;
		stack<int> s;

		int cur = INT_MIN;
		for(int i = 0; i < preorder.size(); i++){
			if(preorder[i] < cur)
				return false;
			while(!s.empty() && preorder[i] > s.top()){ // right child of cur
				cur = s.top();
				s.pop();
			}
			s.push(preorder[i]);
		}
		return true;
	}
};

int main(){
	LC255 *x = new LC255();
	vector<int> preorder = {4, 2, 1, 3, 6, 5, 7};
	cout << x->verifyPreorder(preorder) << endl;

	return 0;
}