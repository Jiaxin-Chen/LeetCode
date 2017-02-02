import java.util.*;

public class Solution179 {
	/* 179. Largest Number
	 * Given a list of non negative integers, arrange them such that they form the largest number.
	 * 
	 * Input: [3, 30, 34, 5, 9]
	 * Output: 9534330
	 * 
	 * n terms of Time and Space Complexity
	 * Let's assume:
	 * the length of input array is n, average length of Strings in s_num is k,
	 * Then, compare 2 strings will take O(k).
	 * Sorting will take O(nlgn). Appending to StringBuilder takes O(n).
	 * So total will be O(nklgnk) + O(n) = O(nklgnk).
	 * 
	 * Space is pretty straight forward: O(n).
	 */
	
	public String largestNumber(int[] nums){
		if(nums == null || nums.length == 0){
			return "";
		}
		
		String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++){
			strs[i] = String.valueOf(nums[i]);
		}
		
		
		Arrays.sort(strs, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				String str1 = s1 + s2;
				String str2 = s2 + s1;
				return str2.compareTo(str1);
			}
		});
		
		
		if(strs[0].charAt(0) == '0')	
			return "0";
		
		
		// StringBuilder is much faster than String, Runtime 115ms
		StringBuilder res = new StringBuilder();
		for(String str : strs){
			res.append(str);
		}
		return res.toString();
		
		/* Runtime 145ms
		String res = new String();
        for (int i = 0; i < strs.length; i++) {
            res = strs[i]+res;
        }
        return res;
        */
	}
	
	public static void main(String[] args){
		Solution179 res = new Solution179();
		int[] nums = {3, 30, 34, 5, 9};
		
		System.out.println(res.largestNumber(nums));
	}
}
