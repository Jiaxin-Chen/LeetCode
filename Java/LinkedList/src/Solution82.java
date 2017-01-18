
public class Solution82 {
	/* 82. Remove Duplicates from Sorted List II:
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
	 * leaving only distinct numbers from the original list.
	 * 
	 * Input: 1->2->3->3->4->4->5
	 * Output: 1->2->5
	 */
	
	public static ListNode deleteDuplicates(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		
		while(cur != null){
			while(cur.next != null && cur.val == cur.next.val){
				//prev.next = head.next.next;
				cur = cur.next;
			}
			if (prev.next == cur){
				prev = prev.next;
			}else{
				prev.next = cur.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}
