/*
261. Graph Valid Tree
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/


class LC261{
	// Union find
	// Time Complexity: O(nlogn)
	// Runtime: 1ms, beats 58.28%
	public boolean validTree(int n, int[][] edges){

		// Step 1: let each node points to their idx
		int[] parents = new int[n];
		for(int i = 0; i < n; i++){
			parents[i] = i;
		}

		// Step 2: build tree, union part
		for(int[] edge : edges){
			int idx1 = edge[0];
			int idx2 = edge[1];

			// Step 3: find the root
			int root1 = getRoot(parents, idx1);
			int root2 = getRoot(parents, idx2);

			// Because edge[0] and edge[1] should be connected, but if they have the same root, it will be a circle among edge[0], edge[1] and their root
			if(root1 == root2){
				return false;
			}else{
				parents[root1] = root2;
			}
		}

		// Step 4: judge if all the node has the same root, if not, there must be the disconnection in the tree, return false
		int root = getRoot(parents, 0);
		for(int i = 1; i < n; i++){
			if(getRoot(parents, i) != root){
				return false;
			}
		}
		return true;
	}

	// Find the root
	private int getRoot(int[] parents, int idx){
		while(idx != parents[idx]){
			parents[idx] = parents[parents[idx]];
			idx = parents[idx];
		}
		return idx;
	}

	public static void main(String[] args){
		//int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		int[][] edges = new int[][]{{0, 1}, {2, 3}};
		int n = 4;

		LC261 x = new LC261();
		System.out.println(x.validTree(n, edges));
	}
}