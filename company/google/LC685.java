/*
685. Redundant Connection II

In this problem, a rooted tree is a directed graph such that, 
there is exactly one node (the root) for which all other nodes are descendants of this node, 
plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), 
with one additional directed edge added. 
The added edge has two different vertices chosen from 1 to N, 
and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. 
Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, 
where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. 
If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
*/

class LC685{
	// Time Complexity: O(NlogN)

	// There are two cases for the tree structure to be invalid.
    // Case 1: A node having two parents:
    // including corner case: e.g. [[4,2],[1,5],[5,2],[5,3],[2,4]], need two candidates to record the edge
    // Case 2: A circle exists: just normal process

	public int[] findRedundantDirectedConnection(int[][] edges){
		if(edges == null || edges.length == 0 || edges[0].length == 0){
			return new int[2];
		}

		int n = edges.length;
		int[] parents = new int[n + 1];
		int[] candA = new int[2];
		int[] candB = new int[2];
		for(int[] edge : edges){
			// current node doesn't have the parent node yet
			if(parents[edge[1]] == 0){
				parents[edge[1]] = edge[0];
			// current node already has the parent node
			}else{		
				//store the two edges as candidates A and B
				candA = new int[] {parents[edge[1]], edge[1]};
				// Attention: we cannot just let candB = edge, because we need modify edge later, 
				// which means the candB will be modified if we do this.
				candB = new int[] {edge[0], edge[1]}; 
				edge[1] = 0; // let the second node with the second parents to be 0
			}
		}
		System.out.println("candA = [" + candA[0] + ", " + candA[1] + "]");
		System.out.println("candB = [" + candB[0] + ", " + candB[1] + "]");

		for(int i = 0; i <= n; i++){
			parents[i] = i;
		}

		for(int[] edge : edges){
			if(edge[1] == 0){
				continue;
			}
			int idx1 = edge[0], idx2 = edge[1];
			int root1 = getRoot(parents, idx1);
			int root2 = getRoot(parents, idx2);
			if(root2 != root1){
				parents[root2] = root1;
			}else{
				// Case 2: a circle exists
				if(candA[0] == 0){
					return edge;
				// Case 1: a node has two parents + circle
				// Case :{{2, 1}, {3, 1}, {4, 2}, {1, 4}}
				}else{
					return candA;
				}
			}
		}
		// Case 1: a node has two parents
		// Case: {{1, 2}, {1, 3}, {2, 3}}
		return candB;
	}

	private int getRoot(int[] parents, int idx){
		while(idx != parents[idx]){
			parents[idx] = parents[parents[idx]]; // path compression
			idx = parents[idx];
		}
		return idx;
	}


	public static void main(String[] args){
		//int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
		//int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
		int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
		LC685 x = new LC685();
		int[] res = x.findRedundantDirectedConnection(edges);
		System.out.println(res[0] + ", " + res[1]);
	}
}
