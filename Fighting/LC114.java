/*
114. Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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

public class LC114{
	// Iterative Version: In-place.
	// Time Complexity: O(MN), Space Complexity: O(1)
	// Runtime: 3ms, beats 5.28%
	public void flatten(TreeNode root){
		if(root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root.right != null)
			stack.push(root.right);
		if(root.left != null)
			stack.push(root.left);
		TreeNode prev = root;

		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null){
				stack.push(node.left);
			}
			prev.right = node;
			prev.left = null;
			prev = node;
		}
	}


	// Recursive Version:
	// Time Complexity: O(2^N)
	// Runtime: 1ms, beats 25.24%
	private TreeNode prev1 = null;

	public void flatten2(TreeNode root){
		if(root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev1;
		root.left = null;
		prev1 = root;
	}
}