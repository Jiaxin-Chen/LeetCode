import java.util.*;
public class Solution112 {
	/*
	 * 112. Path Sum
	 */
	
	
	// Recursive Version: slower
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null){
            return false;
        }
        
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	// Optimized Recursive Version: Don't have to traverse right part if the left part has path sum
	public boolean hasPathSum2(TreeNode root, int sum){
		if(root == null){
            return false;
        }
        
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        
        if(hasPathSum(root.left, sum - root.val)){
            return true;
        }
        if(hasPathSum(root.right, sum - root.val)){
            return true;
        }
        return false;    
	}
	
	// Iterative Version:
	public boolean hasPathSum3(TreeNode root, int sum){
		if(root == null){
            return false;
        }
        
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        Queue<Integer> sumQ = new LinkedList<Integer>();
        
        nodeQ.offer(root);
        sumQ.offer(sum);
        
        while(!nodeQ.isEmpty()){
            int num = sumQ.poll();
            TreeNode cur = nodeQ.poll();
            if(cur.left == null && cur.right == null && cur.val == num){
                return true;
            }
            if(cur.left != null){
                nodeQ.offer(cur.left);
                sumQ.offer(num - cur.val);
            }
            if(cur.right != null){
                nodeQ.offer(cur.right);
                sumQ.offer(num - cur.val);
            }
        }
        return false;
	}
}
