/*
501. Find Mode in Binary Search Tree

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
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

class LC501{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 16ms, beats 28.00%
	public int[] findMode(TreeNode root){
		
		if(root == null){
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();
		
		DFS(map, root);
		for(int key : map.keySet()){
			if(map.get(key) == maxCount){
				list.add(key);
			}
		}
		int[] modes = new int[list.size()];
		for(int i = 0; i < modes.length; i++){
			modes[i] = list.get(i);
		}
		return modes;
	}

	

	// Inorder traverse
	private void DFS(Map<Integer, Integer> map, TreeNode root){
		if(root == null){
			return;
		}
		DFS(map, root.left);

		map.put(root.val, map.getOrDefault(root.val, 0) + 1);
		maxCount = Math.max(maxCount, map.get(root.val));

		DFS(map, root.right);
	}

//-----------------------------------------------------------------
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 4ms, beats 65.70%
	private int currVal;
	private int currCount = 0;
	private int maxCount = Integer.MIN_VALUE;
	private int modeCount = 0;

	private int[] modes;

	public int[] findMode2(TreeNode root){
		// Step 1: First traverse to find the maxCount and modeCount
		DFS2(root);

		// Step 2: Intialize the modes
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;

		// Step 3: Second traverse to collect the mode in the result modes array
		DFS2(root);
		return modes;
	}

	private void DFS2(TreeNode root){
		if(root == null){
			return;
		}
		DFS2(root.left);

		if(root.val != currVal){
			currVal = root.val;
			currCount = 0;
		}
		currCount++;
		if(currCount > maxCount){
			maxCount = currCount;
			modeCount = 1;
		}else if(currCount == maxCount){
			// Second traverse in Step 3: get the mode in the results mode array
			if(modes != null){
				modes[modeCount] = currVal;
			}
			modeCount++;
		}

		DFS2(root.right);
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);

		LC501 x = new LC501();
		int[] res = x.findMode(root);
		for(int mode : res){
			System.out.print(mode + " ");
		}
		
	}
}