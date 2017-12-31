/*
549. Binary Tree Longest Consecutive Sequence II

Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

Especially, this path can be either increasing or decreasing. 
For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. 
On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

Example 1:
Input:
        1
       / \
      2   3
Output: 2
Explanation: The longest consecutive path is [1, 2] or [2, 1].
Example 2:
Input:
        2
       / \
      1   3
Output: 3
Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
Note: All the values of tree nodes are in the range of [-1e7, 1e7].
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC549{
	// Time Complexity: O(N)
	// Runtime: 13ms, beats 38.19%
	public int longestConsecutive(TreeNode root){
		DFS(root);
		return max;
	}

	private int max = 0;

	// post-order
	private int[] DFS(TreeNode root){
		if(root == null){
			return new int[]{0, 0};
		}
		// Step 1: post-order
		int[] left = DFS(root.left);
		int[] right = DFS(root.right);

		// indicates the decreasing order and increaseing order seperately. 
		int decreasing = 1, increasing = 1;

		// Step 2: traverse left and right subtree 
		if(root.left != null){
			if(root.left.val - 1 == root.val){
				decreasing = left[0] + 1;
			}
			if(root.left.val + 1 == root.val){
				increasing = left[1] + 1;
			}
		}
		if(root.right != null){
			if(root.right.val - 1 == root.val){
				decreasing = Math.max(decreasing, right[0] + 1);
			}
			if(root.right.val + 1 == root.val){
				increasing = Math.max(increasing, right[1] + 1);
			}
		}

		// Step 3: because we can have child-parent-child order, 
		// it can be child--increasing(decreasing from parent)--parent--increasing--child, that's why decreaing + increasing
		// and we need substract 1 because we compute the parent node repeatedly.
		max = Math.max(max, decreasing + increasing - 1);

		return new int[]{decreasing, increasing};
	}

	public static void main(String[] args){
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(3);
    	root.right.right = new TreeNode(4);
    	root.right.right.right = new TreeNode(5);

    	LC549 x = new LC549();
    	System.out.println(x.longestConsecutive(root));
    }
}