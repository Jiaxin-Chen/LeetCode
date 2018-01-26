/*
206. Reverse Linked List

Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class LC206{

	// Iterative
	// Time Complexity :O(N)
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = head, cur = head.next;

		while(cur != null){
			ListNode next = cur.next;
			cur.next = prev;
			dummy.next = cur;
			prev = cur;
			cur = next;
		}
		head.next = null;
		return dummy.next;
	}

	// Recursive
	// Time Complexity: O(N)
	public ListNode reverseList2(ListNode head){	
		return recursion(head, null);
	}

	private ListNode recursion(ListNode head, ListNode newHead){
		if(head == null){
			return newHead;
		}
		ListNode next = head.next;
		head.next = newHead;

		return recursion(next, head);
	}
}