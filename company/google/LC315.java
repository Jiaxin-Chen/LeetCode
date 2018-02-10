/*
315. Count of Smaller Numbers After Self
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
*/

import java.util.*;

// Runtime: 9ms, beats 84.21%
class LC315{
	// we need build a BST by ourself, and add a new smallerCount field
	class TreeNode{
		int val;
		int smallerCount;
		TreeNode left;
		TreeNode right;
		TreeNode(int v, int c){
			val = v;
			smallerCount = c;
		}
	}

	// Time Complexity: O(nlogn)
	public List<Integer> countSmaller(int[] nums) {
		
        if(nums == null || nums.length == 0){
        	return new LinkedList<Integer>();
        }
        Integer[] res = new Integer[nums.length];
        TreeNode root = null;

        // traverse from the right, so that we can make sure we calculate the right part for each nums[i]
        for(int i = nums.length - 1; i >= 0; i--){
        	root = insert(root, res, nums[i], i, 0);
        }
        return Arrays.asList(res);
    }

    private TreeNode insert(TreeNode root, Integer[] res, int val, int idx, int preTotalCount){
    	if(root == null){
    		root = new TreeNode(val, 0);
    		res[idx] = preTotalCount;
    	}
    	// only change the preTotalCount when going right,
        // 1) preTotalCount is the count before root.parent
        // 2) root.smallerCount is the count between root.parent and root
        // 3) num > root.val ? 1 : 0 is the count of root itself, 
        // if the statement of question is "smaller or equals to", it will be always 1
    	else if(val >= root.val){
    		root.right = insert(root.right, res, val, idx, preTotalCount + root.smallerCount + (val > root.val ? 1 : 0));
    	}
    	// only change segmentLeftCount when going left
        // at this time, root.parent <= num < root, so increase root.segmentLeftCount
    	else{
    		root.smallerCount++;
    		root.left = insert(root.left, res, val, idx, preTotalCount);
    	}
    	return root;
    }

    public static void main(String[] args){
    	LC315 obj = new LC315();
    	int[] nums = new int[]{5, 2, 6, 1};
    	System.out.println(obj.countSmaller(nums));
    }
}