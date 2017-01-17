
public class Solution24 {
	/* 24. Swap Nodes in Pairs:
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * Input: 1 -> 2 -> 3 -> 4
	 * Output: 2 -> 1 -> 4 -> 3
	 * Complexity: Time 
	 */
	
	public static ListNode swapPairs(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode prev = new ListNode(0);
		dummy.next = head.next;
		prev.next = head;
		
		ListNode cur = head;
		
		while (cur != null && cur.next != null){
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = cur;
			prev.next = next;
			
			prev = cur;
			cur = cur.next;
		}
		
		return dummy.next;
	}
	
	
	public static ListNode swapPairs2(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode next = head.next;
		head.next = swapPairs2(head.next.next);
		next.next = head;
		return next;
	}
}
