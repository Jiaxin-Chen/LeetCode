import java.util.*;

public class Solution107 {
	/*
	 * 107. Binary Tree Level Order Traversal II:
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
	 * (ie, from left to right, level by level from leaf to root).
	 */
	
	// BFS Version: Faster
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> levelList = new LinkedList<Integer>();
            while(levelNum-- > 0){
                TreeNode cur = queue.poll();
                if(cur.left != null)    queue.offer(cur.left);
                if(cur.right != null)   queue.offer(cur.right);
                levelList.add(cur.val);
            }
            list.add(0, levelList);
        }
        return list;
	}
	
	// DFS Version: Slower
	public List<List<Integer>> levelOrderBottom2(TreeNode root){
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Helper(list, root, 0);
		return list;		
	}
	
	private void Helper(List<List<Integer>> list, TreeNode root, int level){
		if(root == null){
			return;
		}
		if(list.size() <= level){
			list.add(0, new LinkedList<Integer>());
		}
		Helper(list, root.left, level + 1);
		Helper(list, root.right, level + 1);
		list.get(list.size() - level - 1).add(root.val);
	}
}
