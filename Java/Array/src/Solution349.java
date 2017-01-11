import java.util.*;

public class Solution349 {
	/* 349. Intersection of Two Arrays:
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
	 * Output: [2]
	 * Complexity: Time O(N)
	 */
	
	public static int[] intersection(int[] nums1, int[] nums2){
		Set<Integer> set = new HashSet<>();
		Set<Integer> interset = new HashSet<>();
		
		for (int i = 0; i < nums1.length; i++){
			set.add(nums1[i]);
		}
		
		for (int i = 0; i < nums2.length; i++){
			if (set.contains(nums2[i])){
				interset.add(nums2[i]);
			}
		}
		
		int[] result = new int[interset.size()];
		int i = 0;
		for (Integer num : interset){
			result[i++] = num;		
		}
		
		return result;
	}
}
