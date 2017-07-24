/*
261. Graph Valid Tree

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/

/*
To tell whether a graph is a valid tree, we have to:
1) Make sure there is no cycle in the graph - this has to be a none-cyclic graph;
2) Make sure every node is reached - this has to be a connected graph;
Reference: https://en.wikipedia.org/wiki/Tree_(graph_theory)

Solution:
To test cyclic, we can make an array for each node (as array index), and the array will store the parent of the node (as array index). 
Every time we fetch a new pair of nodes, we trace the root node (the deepest parent node) of these two nodes, if it has the same root, then is will be a cycle; 
otherwise, we set the parent of second node to be the first node;
After we make sure there is node cycle in the graph, we simple test if there is enough edges to make this graph connected.
*/

#include<iostream>
#include<vector>

using namespace std;

class LC261{
public: 
	// Time Complexity: O(N)
	// Runtime: 12ms, beats 65.09%
	bool validTree(int n, vector<pair<int, int>>& edges){
		vector<int> node(n, 0);

		for(int i = 0; i < n; i++)
			node[i] = i;

		for(int i = 0; i < edges.size(); i++){
			int f = edges[i].first;
			int s = edges[i].second;

			while(f != node[f])
				f = node[f];
			while(s != node[s])
				s = node[s];

			if(node[f] == node[s])
				return false;

			// set the parent of second node to be the first node
			node[s] = f;  
		}
		return edges.size() == n-1;
	}
};

int main(){
	LC261 x;
	vector<pair<int, int> > edges;
	pair<int, int> p = {0, 1}; edges.push_back(p);
	p = {1, 2}; edges.push_back(p);
	p = {2, 3}; edges.push_back(p);
	p = {1, 3}; edges.push_back(p);
	p = {1, 4}; edges.push_back(p);
	int n = 5;

	cout << x.validTree(n, edges) << endl;

	return 0;
}