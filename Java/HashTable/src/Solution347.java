import java.util.*;

public class Solution347 {
	/*
	 * 347. Top K Frequent Elements:
	 * Given a non-empty array of integers, return the k most frequent elements.
	 * Note: 
	 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
	 * 
	 * Input: 
	 * [1,1,1,2,2,3], k = 2
	 * Output: [1, 2]
	 */
	
	public List<Integer> topKFrequent(int[] nums, int k){
  		if (nums == null || nums.length == 0 || k == 0){
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// Corner case: nums = [1], k = 1
		//if there is only one number in nums, we need the bucket has index 1.
		List<Integer>[] bucket = new List[nums.length + 1];
		List<Integer> res = new ArrayList<Integer>();
		
		for(int num : nums){
			/* Returns the value to which the specified key is mapped, 
			or defaultValue if this map contains no mapping for the key. */
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for(int key : map.keySet()){
			int frequency = map.get(key);
			if(bucket[frequency] == null){
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		
		for(int i = bucket.length - 1; i >= 0 && k > 0; i--){
			if(bucket[i] != null){
				System.out.println(bucket[i]);
				res.addAll(bucket[i]);
				k -= bucket[i].size(); // Much faster than only use return res.subList(0, k)
			}	
		
		}
		//To prevent corner case: int[] nums = {1, 1, 9, 8, 7, 6, 5, 4, 3, 2}; int k = 2;
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		Solution347 res = new Solution347();
		System.out.println(res.topKFrequent(nums, k));
	}
}
