/*
162. Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
class LC162 {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid1 = left + (right - left) / 2;
            int mid2 = mid1 + 1;
            if(nums[mid1] < nums[mid2]){
                left = mid2;
            }else{
                right = mid1;
            }
            System.out.println("left = " + left + ", right = " + right + ", mid1 = " + mid1 + ", mid2 = " + mid2);
        }
        return left;
    }
}