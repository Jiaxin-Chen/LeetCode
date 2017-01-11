import java.util.*;

public class Solution350 {
	/* 350. Intersection of Two Arrays II:
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
	 * Output: [2]
	 * Complexity: Time O(N)
	 */
	
	public static int[] intersetion2(int[] nums1, int[] nums2){
		List<Integer> intersetList = new ArrayList<>();
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		while(i < nums1.length && j < nums2.length){
			if (nums1[i] == nums2[j]){
				intersetList.add(nums1[i]);
				i++;
				j++;
			}
			else if (nums1[i] < nums2[j]){
				i++;
			}
			else{
				j++;
			}
		}
		
		int[] result = new int[intersetList.size()];

		for(i = 0; i < intersetList.size(); i++){
			result[i] = (Integer)intersetList.get(i);
		}
		return result;
	}
}
