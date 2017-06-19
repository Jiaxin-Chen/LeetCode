/*
133. Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

import java.util.*;

class UndirectedGraphNode{
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x){
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}


public class LC133{

	// Time Complexity: ()
	// Runtime: 6ms, beats 65.68%
	private Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		return Helper(node);
	}

	private UndirectedGraphNode Helper(UndirectedGraphNode node){
		if(node == null)
			return null;

		if(map.containsKey(node.label))
			return map.get(node.label);

		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		map.put(cloneNode.label, cloneNode);
		for(UndirectedGraphNode neighbor : node.neighbors){
			cloneNode.neighbors.add(Helper(neighbor));
		}
		return cloneNode;
	}


	// Time Complexity: 
	// Runtime: 
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node){
		return Helper2(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
	}

	private UndirectedGraphNode Helper2(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
		if(node == null)
			return null;

		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		map.put(node, cloneNode);

		for(UndirectedGraphNode neighbor : node.neighbors){
			if(map.containsKey(neighbor))
				cloneNode.neighbors.add(map.get(neighbor));
			else
				cloneNode.neighbors.add(Helper2(neighbor, map));
		}
		return cloneNode;
	}
}



