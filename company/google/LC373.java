/*
373. Find K Pairs with Smallest Sums

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
*/
import java.util.*;

class LC373 {
	// Heap
	// Time Complexity: O(MNlog(MN))
	// Runtime: 110ms, beats 7.59%
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0){
            return res;
        }
        
        // O(MNlog(MN))
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                queue.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        
        // need make sure the queue is not empty
        while(res.size() < k && !queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }

    //------------------------------------------------------------------------------------------
    // Time Complexity: O(klogk)
    // Runtime: 102ms, beats 9.79%
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0){
            return res;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));

        // klogk
        for(int i = 0; i < nums1.length && i < k; i++){
        	queue.offer(new int[]{nums1[i], nums2[0], 0});
        }

        int idx = 1;
        while(res.size() < k && !queue.isEmpty()){
        	int[] cur = queue.poll();
        	res.add(new int[]{cur[0], cur[1]});

        	if(cur[2] == nums2.length - 1){
        		continue;
        	}

        	// cur[2] is the pre index of the nums2
        	queue.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }


    public static void main(String[] args){
    	LC373 obj = new LC373();
    	int[] nums1 = new int[]{1,7,11};
    	int[] nums2 = new int[]{2, 4, 6};
    	int k = 3;
    	List<int[]> res = obj.kSmallestPairs2(nums1, nums2, k);
    	for(int[] pair : res){
    		System.out.println(pair[0] + " " + pair[1]);
    	}
    }
}