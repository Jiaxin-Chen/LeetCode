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

class LC113{
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> res = new LinkedList<>();
		if(root == null){
			return res;
		}
		List<Integer> list = new LinkedList<>();
		list.add(root.val);
		DFS(res, root, list, root.val, sum);
		return res;
	}

	private void DFS(List<List<Integer>> res, TreeNode root, List<Integer> list, int curSum, int sum){
		if(root.left == null && root.right == null && curSum == sum){
			res.add(new LinkedList<Integer>(list));
		}
		if(root.left != null){
			list.add(root.left.val);
			DFS(res, root.left, list, curSum + root.left.val, sum);
			list.remove(list.size() - 1);
		}
		if(root.right != null){
			list.add(root.right.val);
			DFS(res, root.right, list, curSum + root.right.val, sum);
			list.remove(list.size() - 1);
		}
	}


	public static void main(String[] args){
		LC113 X = new LC113();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		int sum = 22;
		List<List<Integer>> res = X.pathSum2(root, sum);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}