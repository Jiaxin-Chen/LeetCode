import java.util.*;

public class Solution456 {
	/* 456. 132 Pattern:
	 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak 
	 * such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers 
	 * as input and checks whether there is a 132 pattern in the list.
	 * 
	 * Input: [1, 2, 3, 4], Output: False
	 * Input: [3, 1, 4, 2], Output: True
	 * Input: [-1, 3, 2, 0], Output: True
	 */
	
	public boolean find132pattern(int[] nums){
		if(nums.length < 3){
			return false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] <= min){
				min = nums[i];
			}else{
				while(!stack.isEmpty()){
					if(stack.peek() >= nums[i]){
						break;
					}
					stack.pop();
					if(stack.pop() > nums[i]){
						return true;
					}
				}
				stack.push(nums[i]);
				stack.push(min);
			}		
		}
		return false;
	}
	
	public static void main(String[] args){
		
		Solution456 res = new Solution456();
		
		int[] nums = {1, 2, 3, 4};
		if(res.find132pattern(nums) == true){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
	}
}
