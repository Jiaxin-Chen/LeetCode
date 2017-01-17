
public class Solution83 {
	/* 83. Remove Duplicates from Sorted List:
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * 
	 * Input: 1->1->2->3->3
	 * Output: 1->2->3
	 */
	
	public static ListNode deleteDuplicates(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		ListNode prev = head, cur = head.next;
		while(cur != null){
			if(prev.val == cur.val){
				prev.next = cur.next;
			}else{
				prev = prev.next;
			}
			cur = cur.next;
		}
		return head;
	}
	
	
	// More concise version
	public static ListNode deleteDuplicates2(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		ListNode cur = head;
		while(cur != null && cur.next != null){
			if(cur.val == cur.next.val){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
			}
		}
		return head;
	}
	
	// Recursive Version
	public static ListNode deleteDuplicates3(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		head.next = deleteDuplicates3(head.next);
		return (head.val == head.next.val) ? head.next : head;
		
	}
}
