/*
257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:
   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:
["1->2->5", "1->3"]
*/

#include<iostream>
#include<vector>

using namespace std;

struct TreeNode{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x): val(x), left(NULL), right(NULL) {}
};

class LC257{
public:
	// Time Complexity: O(NlogN)
	// Runtime: 6ms, beats 26.78%
	vector<string> binaryTreePaths(TreeNode* root){
		vector<string> res;
		if(root == NULL)
			return res;

		DFS(res, root, to_string(root->val));
		return res;
	}

	void DFS(vector<string>& res, TreeNode *root, string path){
		if((root->left == NULL) && (root->right == NULL)){
			res.push_back(path);
			return;
		}

		if(root->left)
			DFS(res, root->left, path + "->" + to_string(root->left->val));
		if(root->right)
			DFS(res, root->right, path + "->" + to_string(root->right->val));

	}
};

int main(){
	return 0;
}

