/*
543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC543{
	// Time Complexity: O(N)
	// Runtime: 11ms, beats 24.30%
	public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
        	return 0;
        }
        DFS(root);
        return res;
    }

    private int res = 0;

    // int DFS(node) returns the Longest-Path-Start-At that node, 
	// and update the result of Longest-Path-Across that node through side effect.
    private int DFS(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	// leftLen is the length of single direction Longest-Path start from left-child
    	int leftSingleLen = DFS(root.left);
    	// rightLen is the length of single direction Longest-Path start from right-child
    	int rightSingleLen = DFS(root.right);

    	// leftPath is the length of single direction Longest-Path start from parent go left
    	int leftSubtreeLen = (root.left == null) ? 0 : leftSingleLen + 1;
    	// rightPath is the length of single direction Longest-Path start from parent go right
    	int rightSubtreeLen = (root.right == null) ? 0 : rightSingleLen + 1;

    	res = Math.max(res, leftSubtreeLen + rightSubtreeLen);
    	return Math.max(leftSubtreeLen, rightSubtreeLen);
    }

	public static void main(String[] args){
		LC543 x = new LC543();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		

		System.out.println(x.diameterOfBinaryTree(root));
	}

}