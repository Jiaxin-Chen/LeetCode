import java.util.*;

public class Solution145 {
	/*
	 * 145. Binary Tree Postorder Traversal:
	 * Given a binary tree, return the postorder traversal of its nodes' values.
	 */
	
	// Recursive Version 1
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> postorder = new LinkedList<Integer>();
		
		if(root == null){
			return postorder;
		}
		
		postorder.addAll(postorderTraversal(root.left));
		postorder.addAll(postorderTraversal(root.right));
		postorder.add(root.val);
		
		return postorder;
	}
	
	
	// Recursive Version 2: Only one instantiation.
	public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> postorder = new LinkedList<Integer>();

		return traversal(postorder, root);
    }
    
    private List<Integer> traversal(List<Integer> postorder, TreeNode root){
        if(root == null){
			return postorder;
		}
		
        traversal(postorder, root.left);
		traversal(postorder, root.right);
		postorder.add(root.val);
		
		return postorder;
    }
    
    // Iterative Version 1(actually slower than recursive version for postorder traversal)
    public List<Integer> postorderTraversal3(TreeNode root){
    	List<Integer> postorder = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();	
    	TreeNode cur = root, lastNode = null;
    	
    	while(!stack.isEmpty() || cur != null){
    		if(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}else{
    			TreeNode tmp = stack.peek();
    			if(tmp.right != null && lastNode != tmp.right){
    				cur = tmp.right;
    			}else{
    				postorder.add(tmp.val);
    				lastNode = stack.pop();
    			}
    		}
    	}
    	return postorder;
    }
    
    // Iterative version: Genius!! More concise, understandable and readable!!! But still slower...
    public List<Integer> postorderTraversal4(TreeNode root){
    	List<Integer> postorder = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	if(root == null){
    		return postorder;
    	}
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode cur = stack.pop();
    		postorder.add(0, cur.val);
    		
    		if(cur.left != null){
    			stack.push(cur.left);
    		}
    		if(cur.right != null){
    			stack.push(cur.right);
    		}
    	}
    	
    	return postorder;
    }
}
