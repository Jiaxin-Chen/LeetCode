
public class Solution453 {
	/* 453. Minimum Moves to Equal Array Elements:
	 * Given a non-empty integer array of size n, find the minimum number of moves required 
	 * to make all array elements equal, where a move is incrementing n - 1 elements by 1.
	 * 
	 * Input: [1, 2, 3]
	 * Output: 3
	 * Explanation: Only three moves are needed, [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
	 */
	
	public static int minMoves(int[] nums){
		
		if(nums.length == 0)
            return 0;
        
        int min = nums[0], result = 0;
        
        for (int i = 1; i < nums.length; i++){
            min = Math.min(nums[i], min);
        }
        
        for (int i = 0; i < nums.length; i++){
            result += nums[i] - min;
        }
        
        return result;
		
		/*
		 * Test Case: [1, 1, 2147483647];
		int max = nums[0];
		int result = 0;
		for (int i : nums){
			max = Math.max(max, i);
		}
		// Stupid Bug here!! This makes the step double!!
		for (int i : nums){
			result += max - i;
		}
		return result;
		*/
		
			
	}
}
