/*
337. House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC337 {
	// The time complexity for the naive recursion in step I is indeed exponential. 
	// For each tree node tn at depth d, let T(d) be the number of times the rob function will be called on it. 
	// Then we have T(d) = T(d - 1) + T(d - 2). This is because rob will be called on tn either from its parent (at depth d - 1) or its grandparent (at depth d - 2), 
	// according to its definition. Note T(0) = T(1) = 1, i.e., rob will be called only once for the tree root and its two child nodes. 
	// Therefore T(d) will essentially be the (d+1)-th Fibonacci number (starting from 1), which grows exponentially (more info can be found here).
	// Runtime: 1171ms, beats 3.41%
	 public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
    
        int res = 0;
        if(root.left != null){
            res += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            res += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(res + root.val, rob(root.left) + rob(root.right));  
    }

//--------------------------------------------------------------------------
	// Optimization: Use map to dfs pruning
	// Runtime: 8ms, beats 35.51%
	public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root, new HashMap<TreeNode, Integer>());
    }
    
    private int dfs(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int res = 0;
        if(root.left != null){
            res += dfs(root.left.left, map) + dfs(root.left.right, map);
        }
        if(root.right != null){
            res += dfs(root.right.left, map) + dfs(root.right.right, map);
        }
        res = Math.max(res + root.val, dfs(root.left, map) + dfs(root.right, map));
        map.put(root, res);
        
        return res;
    }



//---------------------------------------------------------------------------------------
	// My fault version..... 
	// I just add the non-adjance level nodes together and doesn't consider the case like:[4,1,null,2,null,3]
    public int rob3(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(dfs(root, true), dfs(root, false));
    }
    
    private int dfs(TreeNode root, boolean isStolen){
        if(root == null){
            return 0;
        }
        
        int res = 0;
        if(isStolen){
            res += root.val;
        }
        res += dfs(root.left, !isStolen) + dfs(root.right, !isStolen);
        
        return res;
    }
}