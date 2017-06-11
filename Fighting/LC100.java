/*
100. Same Tree

Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
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


public class LC100{
	// Recursive Version:
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 24.67%
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		if(p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}

	// DFS Version:
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 2.33%
	public boolean isSameTree2(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		Stack<TreeNode> sp = new Stack<TreeNode>();
		Stack<TreeNode> sq = new Stack<TreeNode>();

		if(p != null)
			sp.push(p);
		if(q != null)
			sq.push(q);

		while(!sp.isEmpty() && !sq.isEmpty()){
			TreeNode pCur = sp.pop();
			TreeNode qCur = sq.pop();
			if(pCur == null && qCur == null)
				continue;
			else if(pCur == null || qCur == null)
				return false;
			else if(pCur.val == qCur.val){
				sp.push(pCur.left);
				sp.push(pCur.right);
				sq.push(qCur.left);
				sq.push(qCur.right);
			}else 
				return false;
		}
		return true;
	}
}