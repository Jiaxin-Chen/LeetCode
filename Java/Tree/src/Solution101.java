import java.util.*;

public class Solution101 {
	/*
	 * 101. Symmetric Tree:
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 */
	
	public boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root.left);
		queue.offer(root.right);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				TreeNode node1 = queue.poll();
				TreeNode node2 = queue.poll();
				if(node1 == null && node2 == null){
					continue;
				}
				if(node1 == null || node2 == null || node1.val != node2.val){
					return false;
				}
				
				queue.offer(node1.left);
				queue.offer(node2.right);
				queue.offer(node1.right);
				queue.offer(node2.left);
			}
		}
		return true;
	}
	
	public boolean isSymmetric2(TreeNode root){
		if(root == null){
			return true;
		}
		return isSubSymmetric(root.left, root.right);
	}
	
	private boolean isSubSymmetric(TreeNode node1, TreeNode node2){
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null || node1.val != node2.val){
			return false;
		}
		return isSubSymmetric(node1.left, node2.right) && isSubSymmetric(node1.right, node2.left);
	}
}
