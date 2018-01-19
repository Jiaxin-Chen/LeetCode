
/*
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

import java.util.*;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class LC023{
	// Time Complexity: O(NKlogK), Space Complexity: O(k), N is the average length of a list
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0){
			return null;
		}

		// Lambda comparison: 
		//PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> (a.val - b.val));

		//
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			public int compare(ListNode a, ListNode b){
				return a.val - b.val;
			}
		});

		// Time Complexity: O(Nlogk)
		for(ListNode list : lists){
			if(list != null){
				queue.offer(list); // offer operation for PriorityQueue: log(k)
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode node = dummy;

		// Time Complexity: O(NKlogk), NK means we need go through all the nodes in all the lists
		while(!queue.isEmpty()){
			ListNode cur = queue.poll();  // poll operation for PriorityQueue: log(k)
			if(cur.next != null){
				queue.offer(cur.next);
			}
			node.next = cur;
			node = node.next;
		}
		return dummy.next;
	}
}