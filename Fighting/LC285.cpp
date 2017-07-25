/*
285. Inorder Successor in BST

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
Note: If the given node has no in-order successor in the tree, return null.
 */

#include<iostream>

using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL){}
};

class LC285{
public: 
	// Time Complexity: O(logN)
	// Runtime: 29ms, beats 23.77%
	TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p){
		if(root == NULL || p == NULL)
			return NULL;

		if(root->val <= p->val){
			return inorderSuccessor(root->right, p);
		}else{
			TreeNode *left = inorderSuccessor(root->left, p);
			return (left != NULL) ? left : root;
		}
	}

	TreeNode* inorderPrecossor(TreeNode* root, TreeNode* p){
		if(root == NULL || p == NULL)
			return NULL;

		if(root->val >= p->val){
			return inorderPrecossor(root->left, p);
		}else{
			TreeNode *right = inorderPrecossor(root->right, p);
			return (right != NULL) ? right : root;
		}

	}
};

int main(){
	LC285 *x = new LC285();
	return 0;
}