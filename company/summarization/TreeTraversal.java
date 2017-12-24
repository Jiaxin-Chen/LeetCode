import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class TreeTraversal{

	// Iterative version:

	// Time Compelxity: O(N)
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> preorder = new LinkedList<>();
		if(root == null){
			return preorder;
		}
		Stack<TreeNode> stack = new Stack<>();

		while(!stack.isEmpty() || root != null){
			if(root != null){
				preorder.add(root.val);
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				root = root.right;
			}
		}
		return preorder;
	}

	// Time Complexity: O(N)
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> inorder = new ArrayList<>();
		if(root == null){
			return inorder;
		}
		Stack<TreeNode> stack = new Stack<>();

		while(!stack.isEmpty() || root != null){
			// Step 1: traversal the left node first, it will traverse until the most left node
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				// Step 2: get the left node
				root = stack.pop();
				// Step 3: add to the inorder list, as the root node of current tree
				inorder.add(root.val);
				// Step 4: let the root equals to the right, then to see if the node.right has subtrees
				root = root.right;
			}
		}
		return inorder;
	}
	
	// Time Complexity: O(N)
	public List<Integer> postorderTraversal(TreeNode root){
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


	//-----------------------------------------------------------------------------

	// Recursive version:

	// Time Complexity: O(N)
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> preorder = new LinkedList<>();
		return Traversal(root, preorder);
	}

	private List<Integer> Traversal(TreeNode root, List<Integer> preorder){
		if(root == null){
			return preorder;
		}
		preorder.add(root.val);
		Traversal(root.left, preorder);
		Traversal(root.right, preorder);
		return preorder;
	}

	// Time Complexity: O(N), because it traversals all the nodes
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> inorder = new ArrayList<>();
		return Traversal(root, inorder);
	}

	private List<Integer> Traversal(TreeNode node, List<Integer> inorder){
		if(node == null){
			return inorder;
		}
		Traversal(node.left, inorder);
		inorder.add(node.val);
		Traversal(node.right, inorder);
		return inorder;
	}

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


	public static void main(String[] args){
		TreeTraversal X = new TreeTraversal();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);


		List<Integer> res = X.postorderTraversal(root, sum);
		System.out.println(res);
	}
}


