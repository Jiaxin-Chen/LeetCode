/*
314. Binary Tree Vertical Order Traversal

Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
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

class LC314{
	// Time Complexity: O(N)
	// Runtime: 5ms, beats 36.6%
	public List<List<Integer> > verticalOrder(TreeNode root){
		
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();

		// Step 1: put node, col into queue at the same time
		queue.offer(root);
		cols.offer(0);

		int min = 0, max = 0; // [min, max] is the range of thethe vertical columns


		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int col = cols.poll();

			// Step 2: for new col, intialize and add current node.val into the list.
			if(!map.containsKey(col)){
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			// Step 3: Every left child access col - 1 while right child col + 1
			if(node.left != null){
				queue.offer(node.left);
				cols.offer(col - 1);
				min = Math.min(min, col - 1);
			}
			if(node.right != null){
				queue.offer(node.right);
				cols.offer(col + 1);
				max = Math.max(max, col + 1);
			}
		}

		for(int i = min; i <= max; i++){
			res.add(map.get(i));
		}
		return res;
	}
		
	public static void main(String[] args){
		LC314 x = new LC314();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(2);
		root.right.left.left = new TreeNode(5);

		List<List<Integer>> res = x.verticalOrder(root);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}






















