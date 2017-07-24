/*
270. Closest Binary Search Tree Value

Given a non-empty binary search tree and a target value, 
find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

#include<iostream>
#include<stdlib.h>
#include<math.h>

using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class LC270{
public:
	// Time Complexity: O(N)
	// Runtime: 9ms, beats 23.71%
	int closestValue(TreeNode* root, double target){
		if(root == NULL)
			return 0;

		auto closest = root->val;
		while(root){
			closest = fabs(target - root->val) < fabs(target - closest) ? root->val : closest;
			if(closest == target)
				return closest;
			root = (target < root->val) ? root->left : root->right;
		}
		return closest;
	}
};

int main(){
	LC270 x;
	return 0;
}