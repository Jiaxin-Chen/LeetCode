/*
143. Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class LC143{
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 9.18%
	public void reorderList(ListNode head1){
		if(head1 == null || head1.next == null)
			return;

		// Find the middle of the list
		ListNode slow = head1, fast = head1.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		// Reverse the second half of the list
		ListNode head2 = slow.next;
		slow.next = null;
		ListNode cur = head2.next;
		head2.next = null;
		while(cur != null){
			ListNode next = cur.next;
			cur.next = head2;
			head2 = cur;
			cur = next;
		}

		// Combine the two sublist together
		while(head1 != null && head2 != null){
			ListNode next1 = head1.next;
			ListNode next2 = head2.next;
			head1.next = head2;
			head2.next = next1;
			head1 = next1;
			head2 = next2;
		}
	}
}