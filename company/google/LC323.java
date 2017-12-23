/*
323. Number of Connected Components in an Undirected Graph

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/

import java.util.*;

class LC323{
	// Time Complexity: O(log)
	// Runtime: 2ms, beats 80.70%
	public int countComponents(int n, int[][] edges){
		if(edges == null || edges.length == 0 || edges[0].length == 0) {
			return n;
		}
		if(n < 1){
			return 0;
		}

		// Step 1: Let each idx's parent root be itself firstly
		int[] parents = new int[n];
		for(int idx = 0; idx < n; idx++){
			parents[idx] = idx;
		}
		int count = n;

		// Step 2: Union part: if the two idx has different root, assign idx2's root be idx1's root
		for(int[] edge : edges){
			int idx1 = edge[0], idx2 = edge[1];
			int root1 = getRoot(parents, idx1);
			int root2 = getRoot(parents, idx2);

			if(root1 != root2){
				parents[root2] = root1;
				count--;
			}
		}
		return count;
	}

	// Step 3: find part
	private int getRoot(int[] parents, int idx){
		while(idx != parents[idx]){
			parents[idx] = parents[parents[idx]]; // path compression, with this line, runtime reduce from 8ms to 2ms
			idx = parents[idx];
		}
		return idx;
	}

//----------------------------------------------------------------------------------------------------

	// Time Complexity: O(NlogN)
	// Runtime: 19ms, beats 21.87%
	public int countComponents2(int n, int[][] edges){
		if(edges == null || edges.length == 0 || edges[0].length == 0) {
			return n;
		}
		if(n < 1){
			return 0;
		}

		int count = 0;
		Map<Integer, ArrayList<Integer> > map = new HashMap<>(); // <cur num, connected number list>
		Set<Integer> set = new HashSet<>();

		// Step 1: add every number into the map
		for(int i = 0; i < n; i++){
			map.put(i, new ArrayList<Integer>());
		}

		// Step 2: add the connected number to current number's list
		for(int[] edge : edges){
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		// Step 3: add the number into the set, go through the connected number list
		for(int i = 0; i < n; i++){
			if(set.add(i)){
				count++;
				DFS(map, set, i);
			}
		}
		return count;
	}

	// go through the connected number list and add the connected number into set
	private void DFS(Map<Integer, ArrayList<Integer> > map, Set<Integer> set, int i){
		for(int j : map.get(i)){
			if(set.add(j)){
				DFS(map, set, j);
			}
		}
	}


	public static void main(String[] args){
		int[][] edges = {{0, 1}, {1, 2},  {3, 4}};
		int n = 5;
		LC323 X = new LC323();
		System.out.println(X.countComponents2(n, edges));
	}
}

