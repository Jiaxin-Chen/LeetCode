/*
444. Sequence Reconstruction

Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example 1:

Input:
org: [1,2,3], seqs: [[1,2],[1,3]]

Output:
false

Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
Example 2:

Input:
org: [1,2,3], seqs: [[1,2]]

Output:
false

Explanation:
The reconstructed sequence can only be [1,2].
Example 3:

Input:
org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

Output:
true

Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input:
org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

Output:
true
UPDATE (2017/1/8):
The seqs parameter had been changed to a list of list of strings (instead of a 2d array of strings). Please reload the code definition to get the latest changes.
*/

import java.util.*;

class LC444{
	// BFS
	// Time Complexity: O(N^2)

	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs){
		if(seqs == null || seqs.size() == 0){ 
			return org == null || org.length == 0;
		}
		if(org == null || org.length == 0){
			return seqs == null || seqs.size() == 0;
		}
		
		Map<Integer, Set<Integer>> map = new HashMap<>(); // <prev node, it's directed node>
		Map<Integer, Integer> indegree = new HashMap<>();

		// Step 1: build the directed graph
		for(int i = 0; i < seqs.size(); i++){
			List<Integer> list = seqs.get(i);
			if(!indegree.containsKey(list.get(0))){
				indegree.put(list.get(0), 0);
			}
			for(int j = 1; j < list.size(); j++){
				int pre = list.get(j - 1);
				int cur = list.get(j);

				if(!map.containsKey(pre)){
					map.put(pre, new HashSet<>());
				}
				Set<Integer> set = map.get(pre);
				if(!set.contains(cur)){
					//System.out.println("cur = " + cur);
					indegree.put(cur, indegree.getOrDefault(cur, 0) + 1);
					set.add(cur);
					map.put(pre, set);
				}
			}
		}

		// corner case
		if(indegree.get(org[0]) != 0 || indegree.size() != org.length){
			return false;
		}


		// Step 2: add the node whose indegree = 0 into the queue
		Queue<Integer> queue = new LinkedList<>();
		for(Integer key : indegree.keySet()){
			if(indegree.get(key) == 0){
				queue.offer(key);
				System.out.println(key);
			}
		}



		// Step 3: BFS
		int idx = 0;
		while(!queue.isEmpty()){
			if(queue.size() > 1){
				return false;
			}
			int pre = queue.poll();
			System.out.println("pre = " + pre);
			if(idx >= org.length || org[idx++] != pre){
				return false;
			}
			Set<Integer> set = map.get(pre);
			
			if(set != null){
				for(int cur : set){
					indegree.put(cur, indegree.get(cur) - 1);
					if(indegree.get(cur) == 0){
						queue.offer(cur);
					}
				}
			}
			
		}
		return idx == org.length;
	}


	public static void main(String[] args){
		/*
		int[] org = new int[]{4, 1, 5, 2, 6, 3};
		Integer[] sequence1 = new Integer[]{5, 2, 6, 3};
		Integer[] sequence2 = new Integer[]{4, 1, 5, 2};
		*/

		int[] org = new int[]{1, 2, 3};
		Integer[] sequence1 = new Integer[]{1, 2};
		Integer[] sequence2 = new Integer[]{1, 3};
		Integer[] sequence3 = new Integer[]{2, 3};
		
		List<List<Integer>> seqs = new LinkedList<>();
		seqs.add(Arrays.asList(sequence1));
		seqs.add(Arrays.asList(sequence2));
		seqs.add(Arrays.asList(sequence3));
		LC444 x = new LC444();

		System.out.println(x.sequenceReconstruction(org, seqs));

	}
}