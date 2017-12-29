/*
437. Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
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

class LC437{
	// Time Complexity: O(N^2)
	// Runtime: 22ms, beats 78.99%
	public int pathSum(TreeNode root, int sum) {
		if(root == null){
			return 0;
		}
        return DFS(root, root.val, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int DFS(TreeNode root, int curSum, int sum){
    	if(root == null){
    		return 0;
    	}
    	int count = (curSum == sum) ? 1 : 0;
    	//System.out.println(root.val);
    	if(root.left != null)
    		count += DFS(root.left, root.left.val + curSum, sum);
    	if(root.right != null)
    		count += DFS(root.right, root.right.val + curSum, sum);
    	return count;
    }

//-----------------------------------------------------------------------------------------
    // Concise version
   	// Time Complexity: O(N^2)
    public int pathSum2(TreeNode root, int sum){
    	if(root == null){
    		return 0;
    	}
    	return DFS2(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

    private int DFS2(TreeNode root, int sum){
    	if(root == null){
    		return 0;
    	}
    	int count = (root.val == sum) ? 1 : 0;
    	count += DFS2(root.left, sum - root.val);
    	count += DFS2(root.right, sum - root.val);
    	return count;
    }

//---------------------------------------------------------------------------------------
    // Optimized version:
    // Time Complexity: O(N)
    // Runtime: 16ms, beats 97.34%
    public int pathSum3(TreeNode root, int sum){
    	// Step 1: HashMap to store ( key : the prefix sum, value : how many ways get to this prefix sum)
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(0, 1);
    	return DFS3(map, root, 0, sum);
    }

    private int DFS3(Map<Integer, Integer> map, TreeNode root, int curSum, int sum){
    	if(root == null){
    		return 0;
    	}
    	curSum += root.val;
    	int res = map.getOrDefault(curSum - sum, 0);
    	map.put(curSum, map.getOrDefault(curSum, 0) + 1);

    	res += DFS3(map, root.left, curSum, sum) + DFS3(map, root.right, curSum, sum);
    	map.put(curSum, map.get(curSum) - 1);
    	return res;
    }

    public static void main(String[] args){
		LC437 X = new LC437();
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.right = new TreeNode(-3);
		root.right.right = new TreeNode(11);

		int sum = 8;
		System.out.println(X.pathSum3(root, sum));
	}
}

