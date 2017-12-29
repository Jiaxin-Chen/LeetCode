/*
572. Subtree of Another Tree

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
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

class LC572{
	// Time Complexity: O(mn)
	// Runtime: 24ms, beats 89.04%
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null){
			return false;
		}
		// Step 1: compare the root s and t first
		if(isEqual(s, t)){
			return true;
		}
		// Step 2: compare the left and right child node of s with t
		return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isEqual(TreeNode s, TreeNode t){
    	if(s == null && t == null){
    		return true;
    	}
    	if(s == null || t == null){
    		return false;
    	}
    	return (s.val == t.val) && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }

//---------------------------------------------------------------------------------------
    // Time Complexity: O(mn), Space complexity: O(N)
	// Runtime: 28ms, beats 40.48%
    public boolean isSubtree2(TreeNode s, TreeNode t){
    	if(s == null){
    		return false;
    	}
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(s);

    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		if(isEqual(node, t)){
    			return true;
    		}
    		if(node.left != null){
    			queue.offer(node.left);
    		}
    		if(node.right != null){
    			queue.offer(node.right);
    		}

    	}
    	return false;
    }

	public static void main(String[] args){
		LC572 x = new LC572();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(5);
		//root.left.right.left = new TreeNode(0);

		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(2);

		System.out.println(x.isSubtree2(root, root2));
	}
}