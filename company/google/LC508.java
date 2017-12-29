/*
508. Most Frequent Subtree Sum
Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
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


class LC508{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 25ms, beats 22.58%
	public int[] findFrequentTreeSum(TreeNode root){
		if(root == null){
			return new int[0];
		}

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new LinkedList<>();

		DFS(map, root);

		for(Integer key : map.keySet()){
			if(map.get(key) == maxCount){
				list.add(key);
			}
		}
		System.out.println(list);
		int[] res = new int[list.size()];
		for(int i = 0; i < res.length; i++){
			res[i] = list.get(i);
		}
		return res;
	}

	// post traverse
	private int DFS(Map<Integer, Integer> map, TreeNode root){
		if(root == null){
			return 0;
		}
		int left = DFS(map, root.left);
		int right = DFS(map, root.right);

		int sum = left + right + root.val;

		map.put(sum, map.getOrDefault(sum, 0) + 1);
		maxCount = Math.max(maxCount, map.get(sum));

		return sum;
	}


	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-5);

		LC508 x = new LC508();
		int[] res = x.findFrequentTreeSum(root);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i] + " ");
		}
	}
}