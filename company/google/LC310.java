/*
310. Minimum Height Trees

For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/

import java.util.*;

class LC310{
	// BFS
	// Time Complexity: O(N)
	// Runtime: TLE...
	public List<Integer> findMinHeightTrees(int n, int[][] edges){
		//Basically, the idea is to eat up all the leaves at the same time, until one/two leaves are left.

		// The actual implementation is similar to the BFS topological sort. 
		// Remove the leaves, update the degrees of inner vertexes. Then remove the new leaves. 
		// Doing so level by level until there are 2 or 1 nodes left. What’s left is our answer!

		List<Set<Integer>> tree = new LinkedList<>();
		List<Integer> leaves = new LinkedList<>();

		if(edges == null || edges.length == 0){
			leaves.add(0);
			return leaves;
		}

		// Step 1: construct the graph
		for(int i = 0; i < n; i++){
			tree.add(new HashSet<Integer>());
		}
		for(int[] edge : edges){
			tree.get(edge[0]).add(edge[1]);
			tree.get(edge[1]).add(edge[0]);
		}
		// Step 2: get the leaves which only have one connected node
		for(int i = 0; i < n; i++){
			if(tree.get(i).size() == 1){
				leaves.add(i);
			}
		}

		// Step 3: because the minimum height tree should be the balanced tree, so the left leaves should <= 2 when it comes to minimum tree
		while(n > 2){
			int size = leaves.size();
			List<Integer> newLeaves = new LinkedList<>();
			// bfs: update the graph
			for(int i = 0; i < size; i++){
				int leave = leaves.get(i);
				int connectedNode = tree.get(leave).iterator().next();
				tree.get(connectedNode).remove(leave);

				// Step 4: if current node becomes leaves, add into newLeaves list
				if(tree.get(connectedNode).size() == 1){
					newLeaves.add(connectedNode);
				}
			}
			n -= size;
			leaves = newLeaves;
		}
		return leaves;
	}

	public static void main(String[] args){
		int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		int n = 6;
		LC310 X = new LC310();
		System.out.println(X.findMinHeightTrees(n, edges));
	}
}