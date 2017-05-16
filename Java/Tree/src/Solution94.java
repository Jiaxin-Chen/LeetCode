import java.util.*;

public class Solution94 {
	/*
	 * 94. Binary Tree Inorder Traversal:
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 */
	
	// Recursive Version 1: Time O(N), Space O(N)
	public List<Integer> inorderTraversal(TreeNode root){
		// We'll instantiate a new list at each recursive call
		List<Integer> inorder = new LinkedList<Integer>();
		
		if(root == null){
			return inorder;
		}
		
		inorder.addAll(inorderTraversal(root.left));
		inorder.add(root.val);
		inorder.addAll(inorderTraversal(root.right));
		
		return inorder;
	}
	
	
	/* Recursive Version 2: Time O(N), Space O(1)
	 * Advantage: we don't have to instantiate a new List at each recursive call, 
	 * 			  which saves lots of space
	 */
	public List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> inorder = new LinkedList<Integer>();	
		return traversal(inorder, root);
    }
    
    private List<Integer> traversal(List<Integer> inorder, TreeNode root){
        if(root == null){
            return inorder;
        }
        traversal(inorder, root.left);
        inorder.add(root.val);
        traversal(inorder, root.right);
        
        return inorder;
	}
    
    
    // Iterative Version: Time O(N), faster
    public List<Integer> inorderTraversal3(TreeNode root){
    	List<Integer> inorder = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	
    	while(!stack.isEmpty() || cur != null){
    		if(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}else{
    			cur = stack.pop();
    			inorder.add(cur.val);
    			cur = cur.right;
    		}
    	}
    	
    	return inorder;
    }
    
}
