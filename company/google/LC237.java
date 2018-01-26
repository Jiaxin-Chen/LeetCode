/*
237. Delete Node in a Linked List

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class LC237{
	// Time Complexity: O(1)
	public void deleteNode(ListNode node){
		if(node == null){
			return;
		}

		/*
		// My fault version, think about it! cannot pass case like [0, 1], node = 0
		ListNode next = node.next;
		node = next;
		node.next = next.next;
		*/

		node.val = node.next.val;
        node.next = node.next.next;
	}
}