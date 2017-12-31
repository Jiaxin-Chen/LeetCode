/*
298. Binary Tree Longest Consecutive Sequence

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC298{
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 14.93%
	public int longestConsecutive(TreeNode root) {
        if(root == null){
        	return 0;
        }

        DFS(root, 0, root.val);
        return max;
    }

    private int max = 0;

    private void DFS(TreeNode root, int curMax, int target){
    	if(root == null){
    		return;
    	}

    	curMax = (root.val == target) ? curMax + 1 : 1;
    	max = Math.max(curMax, max);
    	System.out.println("cur.val = " + root.val + ", curMax = " + curMax + ", target = " + target);
    	DFS(root.left, curMax, root.val + 1);
    	DFS(root.right, curMax, root.val + 1);
    }

    public static void main(String[] args){
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(3);
    	root.right.left = new TreeNode(2);
    	root.right.right = new TreeNode(4);
    	root.right.right.right = new TreeNode(5);

    	LC298 x = new LC298();
    	System.out.println(x.longestConsecutive(root));
    }
}