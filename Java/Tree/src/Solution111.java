import java.util.*;

public class Solution111 {
	/*
	 * 111. Minimum Depth of Binary Tree:
	 * Given a binary tree, find its minimum depth.
	 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	 */
	
	 public int minDepth(TreeNode root){
		 if(root == null) return 0;
		 int leftCount = minDepth(root.left);
		 int rightCount = minDepth(root.right);
		 return (leftCount == 0 || rightCount == 0) ? leftCount + rightCount + 1 : Math.min(leftCount, rightCount);
	 }
	 
	 
	 
	 public int minDepth2(TreeNode root){
		 if(root == null) return 0;
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 
		 int count = 0;
		 queue.offer(root);
		 
		 while(!queue.isEmpty()){
			 count++;
			 int size = queue.size();
			 while(size-- > 0){
				 TreeNode cur = queue.poll();
				 if(cur.left != null){
					 queue.offer(cur.left);
				 }
				 if(cur.right != null){
					 queue.offer(cur.right);
				 }
				 if(cur.left == null || cur.right == null){
					 return count;
				 }
			 }
		 }
		 return 0;
	 }
}
