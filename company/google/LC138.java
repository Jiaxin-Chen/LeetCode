/*
138. Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

import java.util.*;

class RandomListNode{
	int label;
	RandomListNode next, random;
    RandomListNode(int x) { 
    	this.label = x; 
    }
}

class LC138{
	// Time Complexity: o(N)
	// Runtime: 6ms, beats 29.29%
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null){
			return null;
		}

		Map<RandomListNode, RandomListNode> map = new HashMap<>();

		// Step 1: copy all the nodes to the map 
		RandomListNode node = head;
		while(node != null){
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}

		// Step 2: Due to the deep copy, we need assign the next and random pointers
		// only by the map.get(node) value
		node = head;
		while(node != null){
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		// Step 3
		return map.get(head);
	}


}

