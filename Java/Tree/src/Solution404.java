import java.util.*;

public class Solution404 {
	/* 404. Sum of Left Leaves:
	 * Find the sum of all left leaves in a given binary tree.
	 */
	
	 public int sumOfLeftLeaves(TreeNode root){
		 if(root == null){
			 return 0;
		 }
		 int sum = 0;
		 if(root.left != null){
			 if(root.left.left == null && root.left.right == null){
				 sum += root.left.val;
			 }else{
				 sum += sumOfLeftLeaves(root.left);
			 }
		 }
		 sum += sumOfLeftLeaves(root.right);
		 return sum;
	 }
	 
	 
	 // BFS version
	 public int sumOfLeftLeaves2(TreeNode root){
		 if(root == null){
	            return 0;
	        }
	        
	        int sum = 0;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        
	        while(!queue.isEmpty()){
	            TreeNode cur = queue.poll();
	            
	            if(cur.left != null){
	               if(cur.left.left == null && cur.left.right == null)
	                    sum += cur.left.val;
	               else
	                    queue.offer(cur.left);
	            }
	            if(cur.right != null)
	                queue.offer(cur.right);
	        }
	        
	        return sum;
	 }
}
