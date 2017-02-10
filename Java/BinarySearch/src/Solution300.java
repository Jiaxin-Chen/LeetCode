
public class Solution300 {
	/*
	 * 300. Longest Increasing Subsequence:
	 * Given an unsorted array of integers, find the length of longest increasing subsequence.
	 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18],
	 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
	 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
	 */
	
	 public int lengthOfLIS(int[] nums){
		 int[] tails = new int[nums.length];
		 int length = 0;
		 for(int i = 0; i < nums.length; i++){
			 int start = 0, end = length;
			 while(start < end){
				 int mid = start + (end - start) / 2;
				 if(tails[mid] < nums[i]){
					 start = mid + 1;
				 }else{
					 end = mid;
				 }
			 }
			 tails[start] = nums[i];
			 if(length == start){
				 length++;
			 }
		 }
		 return length;
	 }
	 
	 public static void main(String[] main){
		 int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		 Solution300 res = new Solution300();
		 System.out.println(res.lengthOfLIS(nums));
	 }
}
