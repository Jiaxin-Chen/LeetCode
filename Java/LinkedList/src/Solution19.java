
public class Solution19 {
	/* 19. Remove Nth Node From End of List:
	 * Given a linked list, remove the nth node from the end of list and return its head.
	 * 
	 * Input: 1->2->3->4->5, n = 2
	 * Output: 1->2->3->5
	 */
	
	public static ListNode removeNthFromEnd(ListNode head, int n){
		if (head == null){
			return null;
		}
		if (n == 0){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;
		for (int i = 1; i <= n + 1; i++){
			fast = fast.next;
		}
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
		
	}
}
