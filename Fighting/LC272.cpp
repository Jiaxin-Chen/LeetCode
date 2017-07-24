/*
272. Closest Binary Search Tree Value II

Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
*/

#include<iostream>
#include<stdlib.h>
#include<math.h>
#include<vector>
#include<stack>

using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class LC272{
public:
	// Time Complexity: O(N)
	// Runtime: 16ms, beats 24.87%
	vector<int> closestKValues1(TreeNode* root, double target, int k){
		vector<int> res;
		DFS(res, root, target, k);
		return res;
	}

	bool DFS1(vector<int>& res, TreeNode* root, double target, int k){
		if(root == NULL)
			return false;

		if(DFS(res, root->left, target, k))
			return true;

		if(res.size() == k){
			if(fabs(res[0] - target) < fabs(root->val - target))
				return true;
			else
				res.erase(res.begin());
		}

		res.push_back(root->val);
		return DFS(res, root->right, target, k);
	}


	// Time Complexity: O(logN)
	// Runtime: 16ms, beats 24.87%
	vector<int> closestKValues2(TreeNode* root, double target, int k){
		vector<int> res;

		stack<int> predecessors;
		stack<int> successors;

		inorder(root, predecessors, target, false);
		inorder(root, successors, target, true);

		while(k-- > 0){
			if(predecessors.empty()){
				res.push_back(successors.top());
                successors.pop();  // return void in c++, return int in java
            }
			else if(successors.empty()){
				res.push_back(predecessors.top());
                predecessors.pop();
            }
			else if(fabs(predecessors.top() - target) < fabs(successors.top() - target)){
				res.push_back(predecessors.top());
                predecessors.pop();
            }
			else{
				res.push_back(successors.top());
                successors.pop();
            }
		}
		return res;

	}

	void inorder(TreeNode *root, stack<int>& stack, double target, bool isReverse){
		if(root == NULL)
			return;

		inorder(isReverse ? root->right : root->left, stack, target, isReverse);

		// early terminate, no need to traverse the whole tree
		if((!isReverse && root->val > target) || (isReverse && root->val <= target))
			return;
		stack.push(root->val);

		inorder(isReverse ? root->left : root->right, stack, target, isReverse);
	}

};

int main(){
	return 0;
}