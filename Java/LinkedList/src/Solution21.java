
public class Solution21 {
	/* 21. Merge Two Sorted Lists:
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes of the first two lists.
	 */
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if (l1 == null && l2 == null){
			return null;
		}
		
		if (l1 == null){
			return l2;
		}
		
		if (l2 == null){
			return l1;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		while (l1 != null && l2 != null){
			if(l1.val <= l2.val){
				head.next = l1;
				l1 = l1.next;
			}else{
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l1 != null){
			head.next = l1;
		}else{
			head.next = l2;
		}
		
		return dummy.next;
	}
	
	 public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
		 if (l1 == null){
			 return l2;
		 }
		 
		 if (l2 == null){
			 return l1;
		 }
		 
		 ListNode head;
		 if (l1.val < l2.val){
			 head = l1;
			 head.next = mergeTwoLists2(l1.next, l2);
		 }else{
			 head = l2;
			 head.next = mergeTwoLists2(l1, l2.next);
		 }
		 return head;
	 }
}
