/*
719. Find K-th Smallest Pair Distance

Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
*/

class LC719{

	// bucket sort: 
	// Time Complexity: O(MN)
	// Runtime: 525ms, beats 15.71%
	public int smallestDistancePair(int[] nums, int k){
		if(nums.length == 0 || k <= 0){
			return 0;
		}
		Arrays.sort(nums);

		int[] bucket = new int[1000000];

		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				int dis = Math.abs(nums[i] - nums[j]);
				bucket[dis]++;
			}
		}
		int count = 0;
		for(int i = 0; i < bucket.length; i++){
			if(bucket[i] != 0){
				count += bucket[i];
				if(count >= k){
					return i;
				}
			}
		}
		return 0;
	}

	// My fault version: 
	// cannot use the heap anymore, because we cannot assume the distance is also in the ascending order.
	public int smallestDistancePair(int[] nums, int k) {
        if(nums.length == 0 || k <= 0){
            return 0;
        }
        Arrays.sort(nums);
        
        PriorityQueue<int[]> queue = 
            new PriorityQueue<>((a, b) -> (Math.abs(nums[a[0]] - nums[a[1]] - Math.abs(nums[b[0]] - nums[b[1]]))));
                                
        for(int i = 0; i < nums.length - 1 && i < k; i++){
            queue.offer(new int[]{i, i + 1});
        }
        k--;                       
        while(k-- > 0 && queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[1] == nums.length - 1){
                continue;
            }
            queue.offer(new int[]{cur[0], cur[1] + 1});
        }
        int[] res = queue.poll();
        return Math.abs(nums[res[0]] - nums[res[1]]);
    }


}