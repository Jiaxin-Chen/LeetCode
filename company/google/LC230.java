/*
230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
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

class LC230{
	// Recursive:
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 45.05%
	public int kthSmallest(TreeNode root, int k){
		if(root == null){
			return 0;
		}
		DFS(root, k);
		return res;
	}

	private int res;

	private	void DFS(TreeNode root, int k){
		if(root == null){
			return;
		}
		DFS(root.left, k);
		count++;
		if(count == k){
			res = root.val;

			//if we don't return here, time complexity: O(N)
			//If we return here, time complexity: O(logN)
			return;        
		}
		DFS(root.right, k);
	}

//-------------------------------------------------------------
	// Iterative
	// Time Complexity: O(logN)
	// Runtime: 3ms, beats 7.92%
	public int kthSmallest2(TreeNode root, int k){
		if(root == null){
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || root != null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				
				if(--k == 0){
					return root.val;
				}
				
				root = root.right;
			}
		}
		return 0;
	}

//-------------------------------------------------------------------
	// Follow up:
	// Insert/delete Time Complexity: O(logN)
	// kSmallest Time Complexity: O(N)
	// Runtime: 1ms, beats 45.05%
	public int kthSmallest3(TreeNode root, int k){
		TreeNodeWithCount rootWithCount = buildTreeNodeWithCount(root);
		kthSmallest(rootWithCount, k);
		return res;
	}

	private int count = 0;

	private TreeNodeWithCount buildTreeNodeWithCount(TreeNode root){
		if(root == null){
			return null;
		}
		TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);

		rootWithCount.left = buildTreeNodeWithCount(root.left);
		rootWithCount.count = ++count;
		rootWithCount.right = buildTreeNodeWithCount(root.right);

		return rootWithCount;
	}

	// Binary Search
	private void kthSmallest(TreeNodeWithCount rootWithCount, int k){
		if(k == rootWithCount.count){
			res = rootWithCount.val;
		}else if(k < rootWithCount.count){
			if(rootWithCount.left != null)
				kthSmallest(rootWithCount.left, k);
		}else{
			if(rootWithCount.right != null)
				kthSmallest(rootWithCount.right, k);
		}
	}


	class TreeNodeWithCount{
		int val;
		int count;
		TreeNodeWithCount left;
		TreeNodeWithCount right;
		TreeNodeWithCount(int x){
			val = x;
			count = 1;
		}
	}


	public static void main(String[] args){
		LC230 x = new LC230();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		int k = 4;

		System.out.println(x.kthSmallest(root, k));
	}
}