import java.util.*;

public class Solution102 {
	/*
	 * 102. Binary Tree Level Order Traversal:
	 * Given a binary tree, return the level order traversal of its nodes' values. 
	 * (ie, from left to right, level by level).
	 * 
	 */
	
	// BFS Version: faster
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root == null){
			return list;
		}
		
		queue.offer(root);
		while(!queue.isEmpty()){
			int levelNum = queue.size();
			List<Integer> levelList = new LinkedList<Integer>();
			while(levelNum-- > 0){
				TreeNode cur = queue.poll();
				if(cur.left != null){
					queue.offer(cur.left);
				}
				if(cur.left != null){
					queue.offer(cur.right);
				}
				levelList.add(cur.val);
			}
			list.add(levelList);
		}
		return list;
	}
	
	
	// DFS Version: slower
	public List<List<Integer>> levelOrder2(TreeNode root){
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Helper(list, root, 0);
		return list;		
	}
	
	private void Helper(List<List<Integer>> list, TreeNode root, int level){
		if(root == null){
			return;
		}
		if(list.size() <= level){
			list.add(new LinkedList<Integer>());
		}
		Helper(list, root.left, level + 1);
		Helper(list, root.right, level + 1);
		list.get(level).add(root.val);
	}
}
