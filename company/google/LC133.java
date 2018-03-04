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

class LC133{
	class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x){
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	// DFS
	// Time Complexity: O(VE), where V is the # of nodes and E is the number of Edges(connections)
	// Runtime: 5ms, beats 63.30%
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		// Step 1: map node to cloned node instead of label to cloned node in case of duplicate labels
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return DFS(node, map);
	}

	private UndirectedGraphNode DFS(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
		if(node == null){
			return null;
		}
		// Step 2: we have visited this node before, just return the clone node
		if(map.containsKey(node)){
			return map.get(node);
		}
		// Step 3: we haven't visited this node before, we need initialize the clone node
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node, clone);
		for(UndirectedGraphNode neighbor : node.neighbors){
			clone.neighbors.add(DFS(neighbor, map));
		}

		return clone;
	}

//-------------------------------------------------------------------------------
	// BFS
	// Time Complexity: O(VE), where V is the # of nodes and E is the number of Edges(connections)
	// Runtime: 10ms, beats 15.85%
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node){
		if(node == null){
			return null;
		}

		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();

		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node, clone);
		queue.offer(node);

		while(!queue.isEmpty()){
			UndirectedGraphNode cur = queue.poll();
			for(UndirectedGraphNode neighbor : cur.neighbors){
				if(!map.containsKey(neighbor)){
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					queue.offer(neighbor);
				}
				UndirectedGraphNode newNeighbor = map.get(neighbor);
				UndirectedGraphNode newClone = map.get(cur);
				newClone.neighbors.add(newNeighbor);
			}
		}
		return clone;
	}










}