
public class Solution143 {
	/* 143. Reorder List:
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * You must do this in-place without altering the nodes' values.
	 * 
	 * Input: 1->2->3->4->5->6
	 * Output: 1->6->2->5->3->4
	 */
	
	 public static void reorderList(ListNode head){
		 if (head == null || head.next == null){
			 return;
		 }
		 
		 
		 // Find the middle of the list
		 ListNode slow = head, fast = head.next;
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

		 
		 //ListNode.outputLinkedList(head);
		 //ListNode.outputLinkedList(head2);
		 		 
		 // Merge the two lists
		 while(head != null && head2 != null){
			 ListNode tmp = head.next;
			 ListNode tmp2 = head2.next;
			 head.next = head2;
			 head2.next = tmp;
			 head = tmp;
			 head2 = tmp2;
		 }		 
	 }	
}
