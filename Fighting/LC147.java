/*
147. Insertion Sort List

Sort a linked list using insertion sort.
*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class LC147{
	// Time Complexity: O(n)
	// Runtime: 43ms, beats 32.33%
	public ListNode insertionSortList(ListNode head){
		if(head == null || head.next == null)
			return head;

		ListNode helper = new ListNode(0);

		while(head != null){
			ListNode prev = helper, next = head.next;
			while(prev.next != null && prev.next.val < head.val){
				prev = prev.next;
			}
			head.next = prev.next;
			prev.next = head;
			head = next;
		}
		return helper.next;
	}
}