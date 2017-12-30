/*
173. Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
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

class LC173{

	Stack<TreeNode> stack;

	public LC173(TreeNode root) {
        stack = new Stack<>();
        fillStack(root);
    }

    // Time Complexity: O(1), Space Complexity: O(h)
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Time Complexity: O(1), Space Complexity: O(h)
    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        fillStack(curr.right);
        return curr.val;
    }


    private void fillStack(TreeNode root){
    	while(root != null){
    		stack.push(root);
    		root = root.left;
    	}
    }
}