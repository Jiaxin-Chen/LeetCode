/*
236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC236{
	// Time Complexity: O(N)
	// Runtime: 14ms, beats 13.50%
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || p == null || q == null){
			return null;
		}
		return dfs(root, p, q);
	}

	private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
		if(root == null){
			return null;
		}
		if(root == p || root == q){
			return root;
		}
		
		TreeNode left = dfs(root.left, p, q);
		TreeNode right = dfs(root.right, p, q);

		// means both p and q are int the right substree
		if(left == null){
			return right;
		}
		// means both p and q are int the left substree
		if(right == null){
			return left;
		}
		// means either p or q in either left or left substree partitionly
		return root;
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		TreeNode p = root.left;
		TreeNode q = root.left.right.right;

		LC236 x = new LC236();
		TreeNode res = x.lowestCommonAncestor(root, p, q);
		System.out.println(res.val);
	}
}