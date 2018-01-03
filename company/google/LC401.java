/*
401. Binary Watch

A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/

import java.util.*;

class LC401{
	// Bit manipulation: amazing
	// Ref: https://leetcode.com/problems/binary-watch/discuss/88458
	
	public List<String> readBinaryWatch(int num){
		List<String> res = new LinkedList<>();
		for(int hour = 0; hour < 12; hour++){
			for(int min = 0; min < 60; min++){
				if(Integer.bitCount(hour) + Integer.bitCount(min) == num){
					res.add(String.format("%d:d", hour, min));
				}
			}
		}
		return res;
	}

	// Backtracking
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 69.13%
	public List<String> readBinaryWatch2(int num){
		List<String> res = new LinkedList<>();
		int[] nums1 = new int[]{8, 4, 2, 1};
		int[] nums2 = new int[]{32, 16, 8, 4, 2, 1};
		for(int i = 0; i <= num; i++){
			List<Integer> list1 = getDigits(nums1, i);
			List<Integer> list2 = getDigits(nums2, num - i);
			for(int num1 : list1){
				if(num1 > 11){
					continue;
				}
				for(int num2 : list2){
					if(num2 > 59){
						continue;
					}
					res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
				}
			}
		}
		return res;
	}

	private List<Integer> getDigits(int[] nums, int count){
		List<Integer> res = new LinkedList<>();
		backtracking(res, count, 0, 0, nums);
		return res;
	}

	private void backtracking(List<Integer> res, int count, int pos, int sum, int[] nums){
		if(count == 0){
			res.add(sum);
			return;
		}
		for(int i = pos; i < nums.length; i++){
			backtracking(res, count - 1, i + 1, sum + nums[i], nums);
		}
	}

	public static void main(String[] args){
		LC401 x = new LC401();
		int num = 1;
		System.out.println(x.readBinaryWatch2(num));
	}
}