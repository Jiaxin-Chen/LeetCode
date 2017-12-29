/*
272. Closest Binary Search Tree Value II

Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
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

class LC272{
	// Time Complexity: O(klogN)
	// Runtime: 5ms, beats 21.35%
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();

        TreeNode curr = root;
        while(curr != null){
        	if(target <= curr.val){
        		// The most closest value to target in the successor is the left node of the current node
        		succ.push(curr);
        		curr = curr.left;
        	}else{
        		// The most closest value to target in the predeccessor is the right node of the current node
        		pred.push(curr);
        		curr = curr.right;
        	}
        }
        while(k-- > 0){
        	if(pred.isEmpty() && succ.isEmpty()){
        		break;
        	}else if(pred.isEmpty()){
        		res.add(getSuccessor(succ));
        	}else if(succ.isEmpty()){
        		res.add(getPredecessor(pred));
        	}else if(Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)){
        		res.add(getPredecessor(pred));
        	}else{
        		res.add(getSuccessor(succ));
        	}
        }
        return res;
    }

    // Return the most closest value to target in the predeccessor is the right node of the current node
    private int getPredecessor(Stack<TreeNode> pred){
    	TreeNode predNode = pred.pop();
    	TreeNode cur = predNode.left;
    	while(cur != null){
    		pred.push(cur);
    		cur = cur.right;
    	}
    	return predNode.val;
    }

    // Return the most closest value to target in the successor is the left node of the current node
    private int getSuccessor(Stack<TreeNode> succ){
    	TreeNode succNode = succ.pop();
    	TreeNode cur = succNode.right;
    	while(cur != null){
    		succ.push(cur);
    		cur = cur.left;
    	}
    	return succNode.val;
    }

    public static void main(String[] args){
    	LC272 x = new LC272();

    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(1);
    	root.right = new TreeNode(5);
    	root.right.left = new TreeNode(4);
    

    	double target = 3.428571;
    	int k = 4;

    	System.out.println(x.closestKValues(root, target, k));
    }
}