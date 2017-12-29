/*
666. Path Sum IV

If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation: 
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:
Input: [113, 221]
Output: 4
Explanation: 
The tree that the list represents is: 
    3
     \
      1

The path sum is (3 + 1) = 4.
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

class LC666{
	// With some effort, we can see the relevant condition for whether a node should be left or right is pos - 1 < 2**(depth - 2). 
	// For example, when depth = 4, the positions are 1, 2, 3, 4, 5, 6, 7, 8, and it's left when pos <= 4.
	
	// Time Complexity: O(N)
	// Runtime: 35.ms, beats 1.89%
	private int res = 0;
	
	public int pathSum(int[] nums){
		if(nums == null){
			return 0;
		}
		TreeNode root = new TreeNode(nums[0] % 10);
		for(int i = 1; i < nums.length; i++){
			int depth = nums[i] / 100, pos = nums[i] / 10 % 10, val = nums[i] % 10;
			pos--;
			TreeNode node = root;

			for(int j = depth - 2; j >= 0; j--){
				if(pos < (1 << j)){
					if(node.left == null){
						node.left = new TreeNode(val);
					}
					node = node.left;
				}else{
					if(node.right == null){
						node.right = new TreeNode(val);
					}
					node = node.right;
				}
				pos %= (1 << j);
			}
		}
		// Attention: we cannot parse res directly because it's parse by value for int primitive type!
		// If we really want to parse the int, we should use the array!
		int[] arr = new int[1];
		DFS(root, root.val, arr);
		return arr[0];
	}
	
	private void DFS(TreeNode root, int curSum, int[] arr){
		System.out.println("root.val = " + root.val);
		System.out.println("curSum = " + curSum);
		
		if(root.left == null && root.right == null){
			arr[0] += curSum;
			System.out.println("res = " + arr[0]);
		}
		if(root.left != null){
			DFS(root.left, curSum + root.left.val, arr);
		}
		if(root.right != null){
			DFS(root.right, curSum + root.right.val, arr);
		}
	}
/*
//---------------------------------------------------------------
	// Correct version: 
	public int pathSum(int[] nums){
		if(nums == null){
			return 0;
		}
		TreeNode root = new TreeNode(nums[0] % 10);
		for(int i = 1; i < nums.length; i++){
			int depth = nums[i] / 100, pos = nums[i] / 10 % 10, val = nums[i] % 10;
			pos--;
			TreeNode node = root;

			for(int j = depth - 2; j >= 0; j--){
				if(pos < (1 << j)){
					if(node.left == null){
						node.left = new TreeNode(val);
					}
					node = node.left;
				}else{
					if(node.right == null){
						node.right = new TreeNode(val);
					}
					node = node.right;
				}
				pos %= (1 << j);
			}
		}
		DFS(root, root.val);
		return res;
	}
	
	private void DFS(TreeNode root, int curSum){
		System.out.println("root.val = " + root.val);
		System.out.println("curSum = " + curSum);
		
		if(root.left == null && root.right == null){
			res += curSum;
			System.out.println("res = " + res);
		}
		if(root.left != null){
			DFS(root.left, curSum + root.left.val);
		}
		if(root.right != null){
			DFS(root.right, curSum + root.right.val);
		}
	}
*/	

//------------------------------------------------------------------------------------
	// we can use num / 10 = 10 * depth + pos as a unique identifier for that node. 
	// The left child of such a node would have identifier 10 * (depth + 1) + 2 * pos - 1, 
	// and the right child would be one greater.

	// Time Complexity: O(N)
	// Runtime: 20ms, beats 9.47%
	public int pathSum3(int[] nums){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums){
			map.put(num / 10, num % 10);
		}
		DFS3(map, nums[0] / 10, nums[0] % 10);
		return res;
	}
	private void DFS3(Map<Integer, Integer> map, int node, int curSum){
		int depth = node / 10, pos = node % 10;
		int left = (depth + 1) * 10 + 2 * pos - 1;
		int right = left + 1;

		if(!map.containsKey(left) && !map.containsKey(right)){
			res += curSum;
		}
		if(map.containsKey(left))
			DFS3(map, left, map.get(left) + curSum);
		if(map.containsKey(right))
			DFS3(map, right, map.get(right) + curSum);
	}


	public static void main(String[] args){
		LC666 x = new LC666();
		int[] nums = {113, 215, 221};
		System.out.println(x.pathSum3(nums));
	}
}