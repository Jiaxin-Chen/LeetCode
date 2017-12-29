/*
270. Closest Binary Search Tree Value

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC270{
	// Recursive: 
	// Time Complexity: O(logN)
	// Runtime: 1ms, beats 3.64%
	public int closestValue(TreeNode root, double target) {
        if(root == null){
        	return 0;
        }
        DFS(root, target);
        return closestVal;
    }

    private int closestVal;
    private double minDiff = Double.MAX_VALUE;


    private void DFS(TreeNode root, double target){
    	if(root == null){
    		return;
    	}
        if(Math.abs(target - (double)root.val) < minDiff){
        	minDiff = Math.abs(target - (double)root.val);
        	closestVal = root.val;
        }
        if(target < (double)root.val){
        	DFS(root.left, target);
        }else{
        	DFS(root.right, target);
        }
    }

    // Iterative: 
    // Time Complexity: O(logN)
    // Runtime: 0ms, beat 19.08%
    public int closestValue2(TreeNode root, double target){
    	if(root == null){
    		return 0;
    	}
    	int res = root.val;
    	while(root != null){
    		if(Math.abs(target - root.val) < Math.abs(target - res)){
    			res = root.val;
    		}
    		if(target < root.val){
    			root = root.left;
    		}else{
    			root = root.right;
    		}
    	}
    	return res;
    }

    public static void main(String[] args){
    	LC270 x = new LC270();
    	/*
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(1);
    	root.right = new TreeNode(5);
    	root.right.left = new TreeNode(4);
    	*/
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(2);

    	double target = 3.428571;

    	System.out.println(x.closestValue2(root, target));
    }
}