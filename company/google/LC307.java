/*
307. Range Sum Query - Mutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

// Runtime: 121ms, beats 78.28%
class NumArray {
    
    class SegmentTree{
    	int start;
    	int end;
    	int sum;
    	SegmentTree left;
    	SegmentTree right;

    	SegmentTree(int start, int end){
    		this.start = start;
    		this.end = end;
    		this.sum = 0;
    		this.left = null;
    		this.right = null;
    	}
    }

    SegmentTree root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    // Time Complexity: O(logN)
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    // Time Complexity: O(logN)
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private SegmentTree buildTree(int[] nums, int start, int end){
    	if(start > end){
    		return null;
    	}
    	SegmentTree root = new SegmentTree(start, end);
    	if(start == end){
    		root.sum = nums[start];
    	}else{
    		int mid = start + (end - start) / 2;
    		root.left = buildTree(nums, start, mid);
    		root.right = buildTree(nums, mid + 1, end);
    		root.sum = root.left.sum + root.right.sum;
    	}
    	return root;
    }

    private void update(SegmentTree root, int pos, int val){
    	if(root.start == root.end){
    		root.sum = val;
    		return;
    	}
    	int mid = root.start + (root.end - root.start) / 2;
    	if(pos <= mid){
    		update(root.left, pos, val);
    	}else{
    		update(root.right, pos, val);
    	}
    	root.sum = root.left.sum + root.right.sum;
    }

    private int sumRange(SegmentTree root, int start, int end){
    	if(root.start == start && root.end == end){
    		return root.sum;
    	}
    	int mid = root.start + (root.end - root.start) / 2;
    	if(end <= mid){
    		return sumRange(root.left, start, end);
    	}else if(start > mid){
    		return sumRange(root.right, start, end);
    	}else{
    		return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
    	}
    }
}



// TLE.....
class NumArray {
    
    int[] arr;

    public NumArray(int[] nums) {
        arr = nums;
    }
    
    // Time Complexity: O(1)
    public void update(int i, int val) {
        arr[i] = val;
    }
    
    // Time Complexity: O(N)
    public int sumRange(int i, int j) {
        int sum = 0;
        for(int idx = i; idx <= j; idx++){
            sum += arr[idx];
        }
        return sum;
    }
}