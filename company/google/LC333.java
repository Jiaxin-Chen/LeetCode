/*
333. Largest BST Subtree
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

// Time Complexity: O(N)
// Runtime: 9ms, beats 7.67%
class LC333{
	class Result{
		// (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]

		int size;
		int lower;
		int upper;

		Result(int size, int lower, int upper){
			this.size = size;
			this.lower = lower;
			this.upper = upper;
		}
	}

	private int max = 0;

	public int largestBSTSubtree(TreeNode root) {
        if(root == null){
        	return 0;
        }
        DFS(root);
        return max;
    }

    private Result DFS(TreeNode root){
    	if(root == null){
    		return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    	}
    	Result left = DFS(root.left);
    	Result right = DFS(root.right);

    	// Because the BST must satisfy the largest value in left subtrees < root.val < the smallest value in the right subtrees
    	if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower){
    		return new Result(-1, 0, 0);
    	}

    	int size = left.size + 1 + right.size;
    	max = Math.max(size, max);
    	return new Result(size, Math.min(left.lower, root.val), Math.max(root.val, right.upper));
    }

    public static void main(String[] args){
    	LC333 x = new LC333();

    	TreeNode root = new TreeNode(10);
    	root.left = new TreeNode(5);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(8);
    	root.right = new TreeNode(15);
    	root.right.right = new TreeNode(7);

    	System.out.println(x.largestBSTSubtree(root));
    }
}