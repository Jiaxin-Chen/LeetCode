
public class Solution92 {
	/* 92. Reverse Linked List II:
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 * Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
	 * 
	 * Input: 1->2->3->4->5->NULL, m = 2 and n = 4
	 * Output: 1->4->3->2->5->NULL
	 */
	
	public static ListNode reverseBetween(ListNode head, int m, int n){
		if (head == null || head.next == null || m == n){
			return head;
		}
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode start = helper, end = head;
		
		for(int i = 1; i < m; i++){
			start = start.next;
		}
		ListNode cur = start.next;
		
		for(int i = 1; i < n; i++){
			end = end.next;
		}
		
		ListNode prev = end.next;
		
		start.next = end;
		while(cur != end){
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		cur.next = prev;
		
		return helper.next;
	}
}
