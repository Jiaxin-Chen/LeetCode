/*
654. Maximum Binary Tree

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
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


class LC654{
	// Recursive:
	// Time Complexity: O(NlogN)
	// Runtime: 18ms, beats 18.66%
	public TreeNode constructMaximumBinaryTree(int[] nums){
		if(nums == null || nums.length == 0){
			return null;
		}
		return DFS(nums, 0, nums.length - 1);
	}

	private TreeNode DFS(int[] nums, int start, int end){
		if(start > end){
			return null;
		}
		int idx = 0, curMax = Integer.MIN_VALUE;
		for(int i = start; i <= end; i++){
			if(nums[i] > curMax){
				curMax = nums[i];
				idx = i;
			}
		}

		TreeNode root = new TreeNode(nums[idx]);
		root.left = DFS(nums, start, idx - 1);
		root.right = DFS(nums, idx + 1, end);
		return root;
	}
//-------------------------------------------------------------------------------
	// Iterative:
	// Time Complexity: O(N)
	// Runtime: 34ms, beats 4.84%
	public TreeNode constructMaximumBinaryTree2(int[] nums){
		LinkedList<TreeNode> queue = new LinkedList<>();

		for(int num : nums){
			TreeNode cur = new TreeNode(num);
			// left subtree
			while(!queue.isEmpty() && queue.peekFirst().val < num){
				cur.left = queue.pop();
			}
			// right subtree
			if(!queue.isEmpty()){
				queue.peekFirst().right = cur;
			}
			queue.addFirst(cur);
		}
		return queue.isEmpty() ? null : queue.peekLast();
	}

	// pre-order
	private String printTree(TreeNode root){
		if(root == null){
			return "null";
		}
		return String.valueOf(root.val) + ", " + printTree(root.left) + ", " + printTree(root.right);
	}

	public static void main(String[] args){
		int[] nums = {3, 2, 1, 6, 0, 5};
		LC654 x = new LC654();

		TreeNode root = x.constructMaximumBinaryTree2(nums);
		System.out.println(x.printTree(root));
	}
}