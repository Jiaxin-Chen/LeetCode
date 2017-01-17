
public class Solution206 {
	/* 206. Reverse Linked List
	 */
	
	public static ListNode reverseList(ListNode head){
		 if(head == null){
			 return null;
		 }
		 
		 ListNode prev = null;
		 ListNode next = null;
		 
		 while (head.next != null){
			 next = head.next;
			 head.next = prev;
			 
			 prev = head;
			 head = next;
		 }
		 head.next = prev;
		 
		 return next;
	}
	
	public static ListNode reverseList2(ListNode head){
		if(head == null){
			return null;
		}
		
		ListNode newHead = null;
		while(head != null){
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		
		return newHead;
	}
	
	
	/* Recursive Solution */
	public static ListNode reverseList3(ListNode head){
		return recursive(head, null);		
	}
	
	private static ListNode recursive(ListNode head, ListNode newHead){
		if (head == null){
			return newHead;
		}
		
		ListNode next = head.next;
		head.next = newHead;
		return recursive(next, head);
	}
}
