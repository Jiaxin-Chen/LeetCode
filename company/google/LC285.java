/*
285. Inorder Successor in BST

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC285{
	// Iterative
	// Time Complexity: O(logN) = O(h), N is the number of the tree nodes, h is the height of the tree
	// Runtime: 5ms, bets 13.72%
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		TreeNode successor = null;

		while(root != null){
			// It should be p.val < root.val, not p.val <= root.val
			// otherwise it will update to the TreeNode p itself
			if(p.val < root.val){
				successor = root;
				root = root.left;
			}else{
				root = root.right;
			}
		}

		return successor;
	}

	// Iterative
	public TreeNode inorderPrecessor(TreeNode root, TreeNode p){
		TreeNode precessor = null;

		while(root != null){
			if(p.val > root.val){
				precessor = root;
				root = root.right;
			}else{
				root = root.left;
			}
		}
		return precessor;
	}


//--------------------------------------------------------------------------------
	// Recursive:
	public TreeNode inorderSuccessor2(TreeNode root, TreeNode p){
		if(root == null){
			return null;
		}

		if(p.val < root.val){
			TreeNode left = inorderSuccessor2(root.left, p);
			return left != null ? left : root;
		}else{
			return inorderSuccessor2(root.right, p);
		}
	}

	public TreeNode inorderPrecessor2(TreeNode root, TreeNode p){
		if(root == null){
			return null;
		}

		if(p.val > root.val){
			TreeNode right = inorderPrecessor2(root.right, p);
			return right != null ? right : root;
		}else{
			return inorderPrecessor2(root.left, p);
		}
	}

	public static void main(String[] args){
		LC285 x = new LC285();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(4);

		TreeNode p = root.right.left;

		TreeNode successor = x.inorderSuccessor2(root, p);
		TreeNode precessor = x.inorderPrecessor2(root, p);

		System.out.println("successor = " + successor.val);
		System.out.println("precessor = " + precessor.val);
	}
}