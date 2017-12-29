/*
530. Minimum Absolute Difference in BST

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   236
  /   \
104   701
  \    /
 227  911

Output:
9

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
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

class LC530{
	// Time Complexity: O(N)
	// Runtime: 14ms ,beats 78.32%
	public int getMinimumDifference(TreeNode root){
		DFS(root);
		return min;
	}

	private int min = Integer.MAX_VALUE;
	private TreeNode prev = null;

	// we need use inorder traverse: because the value of the node in inorder is always smaller than it's later node.
	private void DFS(TreeNode root){
		if(root == null){
			return;
		}
		DFS(root.left);
		if(prev != null){
			min = Math.min(min, root.val - prev.val);
		}
		prev = root;

		DFS(root.right);
	}

	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 20ms ,beats 19.42%
	public int getMinimumDifference2(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;

		// Inorder traverse
		while(!stack.isEmpty() || root != null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				if(prev != null){
					min = Math.min(min, root.val - prev.val);
				}
				prev = root;
				root = root.right;
			}
		}
		return min;
	}


	// Follow up: if the tree isn't a BST
	// Time Complexity: O(NlogN)
	// we can just use preorder traverse, because the inorder sequence is useless, we cannot judge the value of childern compared with the root
	// we can use TreeMap to get the floor and the ceiling value of current node 
	public int getMinimumDifference3(TreeNode root){
		TreeSet<Integer> set = new TreeSet<>();
		DFS3(set, root);
		return min;
	}

	private void DFS3(TreeSet<Integer> set, TreeNode root){
		if(root == null){
			return;
		}
		if(!set.isEmpty()){
			if(set.floor(root.val) != null){
				min = Math.min(min, root.val - set.floor(root.val));
			}
			if(set.ceiling(root.val) != null){
				min = Math.min(min, set.ceiling(root.val) - root.val);
			}
		}
		set.add(root.val);

		DFS3(set, root.left);
		DFS3(set, root.right);
	}



	public static void main(String[] args){
		LC530 x = new LC530();
		TreeNode root = new TreeNode(236);
		root.left = new TreeNode(104);
		root.left.right = new TreeNode(227);
		root.right = new TreeNode(701);
		root.right.right = new TreeNode(991);

		System.out.println(x.getMinimumDifference3(root));
	}
}