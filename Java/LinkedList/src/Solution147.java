
public class Solution147 {
	/* 147. Insertion Sort List:
	 * Sort a linked list using insertion sort.
	 */
	
	public static ListNode insertionSortListNode(ListNode head){
		if (head == null){
			return null;
		}
		
		ListNode helper = new ListNode(0);
		ListNode cur = head, prev = helper;
	
		while(cur != null){
			prev = helper;
			ListNode next = cur.next;
			while(prev.next != null && prev.next.val < cur.val){
				prev = prev.next;
			}
			cur.next = prev.next;
			prev.next = cur;
			cur = next;
		}
		return helper.next;
		
	}
}
