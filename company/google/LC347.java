/*
347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

class LC347 {
	// Time Complexity: O(n log k), space complexity: O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        if(nums == null || k <= 0){
            return res;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        /*
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, Integer>>(){
                @Override
                public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
                    return b.getValue() - a.getValue();
                }
        });*/
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        
        queue.addAll(map.entrySet());
        
        while(res.size() < k){
            Map.Entry entry = queue.poll();
            int key = (int) entry.getKey();
            System.out.println(key);
            res.add(key);
        }
        return res;
    }
}