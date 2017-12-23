 /*
 684. Redundant Connection

 In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), 
with one additional edge added. The added edge has two different vertices chosen from 1 to N, 
and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, 
that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. 
If there are multiple answers, return the answer that occurs last in the given 2D-array. 
The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

Update (2017-09-26):
We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. 
For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
*/

import java.util.*;

class LC684{
	// Time Complexity: O(NlogN)
	// Runtime: 6ms, beats 34.47%
	public int[] findRedundantConnection(int[][] edges){
		if(edges == null || edges.length == 0 || edges[0].length == 0){
			return new int[2];
		}

		// Step 1: let each node points to their idx
		int[] parents = new int[1001];
		for(int idx = 0; idx < 1001; idx++){
			parents[idx] = idx;
		}

		// Step 2: build tree, union part
		// Because only one additional redundant edge added, and return the last occurence, 
		// which means we the edge let root1 == root2 must be the last occurence.
		for(int[] edge : edges){
			int idx1 = edge[0], idx2 = edge[1];
			int root1 = getRoot(parents, idx1);
			int root2 = getRoot(parents, idx2);
			if(root2 != root1){
				parents[root2] = root1;
			}else{
				return edge;
			}
		}
		return new int[2];
	}

	// find the root
	private int getRoot(int[] parents, int idx){
		while(idx != parents[idx]){
			parents[idx] = parents[parents[idx]]; // path compression
			idx = parents[idx];
		}
		return idx;
	}


	public static void main(String[] args){
		int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
		LC684 x = new LC684();
		int[] res = x.findRedundantConnection(edges);
		System.out.println(res[0] + ", " + res[1]);
	}
}