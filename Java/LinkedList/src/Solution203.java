
public class Solution203 {
	/* 203. Remove Linked List Elements:
	 * Remove all elements from a linked list of integers that have value val.
	 * 
	 * Input: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	 * Output: 1 --> 2 --> 3 --> 4 --> 5
	 */
	
	public static ListNode removeElements(ListNode head, int val){
		if (head == null){
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while(head != null){
			if (head.val == val){
				prev.next = head.next;
			}else{
				prev = head;
			}
			head = head.next;
		}
		return dummy.next;
	}
	
	
	/* Recursive Solution! Genius!! */
	public static ListNode removeElements2(ListNode head, int val){
		if (head == null){
			return null;
		}
		//System.out.println(head.next.val);
		head.next = removeElements2(head.next, val);
		
		return head.val == val ? head.next : head;
	}
}
