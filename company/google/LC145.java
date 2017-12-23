/*
145. Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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

class LC145{
	// Recursive version:
	// Time Complexity: O(N)
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> postorder = new LinkedList<>();
		return Traversal(root, postorder);
	}

	private List<Integer> Traversal(TreeNode root, List<Integer> postorder){
		if(root == null){
			return postorder;
		}

		Traversal(root.left, postorder);
		Traversal(root.right, postorder);
		postorder.add(root.val);
		return postorder;
	}

//----------------------------------------------------------------------------
	// Iterative version:
	// Time Complexity: O(N)
	public List<Integer> postorderTraversal2(TreeNode root){
		LinkedList<Integer> postorder = new LinkedList<>();
		if(root == null){
			return postorder;
		}
		Stack<TreeNode> stack = new Stack<>();
		
		while(!stack.isEmpty() || root != null){
			if(root != null){
				// Step 1: always add the root.val to the first position of the list
				postorder.addFirst(root.val);
				stack.push(root);
				// Step 2: because we add root.val into the first position of the list, 
				// we need traverse the right node first
				root = root.right;
			}else{
				// Step 3: get the right node
				root = stack.pop();
				// Step 4: let the root equals to the left, then to see if the node.left has subtrees
				root = root.left;
			}
			
		}
		return postorder;
	}

	public static void main(String[] args){
		LC145 X = new LC145();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		List<Integer> res = X.postorderTraversal2(root);
		System.out.println(res);
	}

}