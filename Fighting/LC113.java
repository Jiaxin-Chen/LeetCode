/*
113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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

// Depth First Search
public class LC113{
	// Time Complexity: O(2^N)
	// Runtime: 4ms, beats 28.92%
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> res = new LinkedList<>();
		if(root == null)
			return res;
		backtracking(res, new LinkedList<Integer>(), root, sum);
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum){
		if(root == null)
			return;
		list.add(root.val);
		if(root.left == null && root.right == null && root.val == sum){
			res.add(new LinkedList<Integer>(list));
		}else{
			backtracking(res, list, root.left, sum - root.val);
			backtracking(res, list, root.right, sum - root.val);
		}
		list.remove(list.size() - 1);
	}
}