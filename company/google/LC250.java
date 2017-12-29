/*
250. Count Univalue Subtrees

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          3   4   5
return 4.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC250{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 10.25%
	public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
        	return 0;
        }
        DFS(root);
        return count;
    }

    private int count = 0;

    private boolean DFS(TreeNode root){
    	if(root == null){
    		return true;
    	}
    	boolean left = DFS(root.left);
    	boolean right = DFS(root.right);

    	// Single node can also be regarded as a subtree
    	if(left && right){
    		if(root.left != null && root.val != root.left.val){
    			return false;
    		}
    		if(root.right != null && root.val != root.right.val){
    			return false;
    		}
    		count++;
    		return true;
    	}
    	return false;
    }

	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);

		LC250 x = new LC250();
		System.out.println(x.countUnivalSubtrees(root));
	}
}