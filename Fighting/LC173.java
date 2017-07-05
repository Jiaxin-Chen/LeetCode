/*
173. Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.
*/

import java.util.*;

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

// Runtime: 6ms, beats 44.57%
public class BSTIterator{

	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root){
		stack = new Stack<TreeNode>();
		while(root != null){
			stack.push(root);
			root = root.left;
		}
	}

	// Time Complexity: O(1)
	/** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Time Complexity: O(h)
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode tmp = node.right;
        while(tmp != null){
        	stack.push(tmp);
        	tmp = tmp.left;
        }
        return node.val;
    }
}