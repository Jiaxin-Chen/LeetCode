/*
95. Unique Binary Search Trees II

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/


import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

public class LC095{
	// Time Complexity: O(N^2)
	// Runtime: 5ms, beats 25.49%
	public List<TreeNode> generateTrees(int n){
		if(n == 0)
			return new ArrayList<TreeNode>();
		return generate(1, n);
	}

	private List<TreeNode> generate(int start, int end){
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(start > end){
			res.add(null);
			return res;
		}
		if(start == end){
			res.add(new TreeNode(start));
			return res;
		}

		List<TreeNode> left = new ArrayList<>(), right = new ArrayList<>();
		for(int i = start; i <= end; i++){
			// Choose i as the root,  the left subtree will contain elements 1 to (i-1), 
			// and the right subtree will contain elements (i+1) to n.
			left = generate(start, i - 1);
			right = generate(i + 1, end);

			for(TreeNode leftNode : left){
				for(TreeNode rightNode: right){
					TreeNode root = new TreeNode(i);
					root.left = leftNode;
					root.right = rightNode;
					res.add(root);
				}
			}
		}
		return res;
	}
}