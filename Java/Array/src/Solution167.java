
public class Solution167 {
	/* 167. Two Sum II - Input array is sorted:
	 * Given an array of integers that is already sorted in ascending order,
	 * find two numbers such that they add up to a specific target number.
	 * 
	 * Input: [2, 7, 11, 15], target = 9
	 * Output: index1 = 1, index2 = 2
	 */
	
	public static int[] twoSum(int[] numbers, int target){
		
		int start = 0, end = numbers.length - 1;
		
		while (start < end){
			if (numbers[start] + numbers[end] == target)
				break;
			if (numbers[start] + numbers[end] > target)
				end--;
			else
				start++;
		}
		return new int[]{start + 1, end + 1};
		
		/* Time Exceed due to time complexity!!!
		 * Too many loops! Time Complexity: O(n^2)
		int[] index = new int[2];
		int sum;
		
		for (int i = 0; i < numbers.length; i++){
			for (int j = i + 1; j < numbers.length; j++){
				sum = numbers[i] + numbers[j];
				if (sum == target){
					index[0] = i + 1;
					index[1] = j + 1;
				}
			}
		}		
		return index;
		*/
	}
}
