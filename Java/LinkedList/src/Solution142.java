
public class Solution142 {
	/* 142. Linked List Cycle II:
	 * Given a linked list, return the node where the cycle begins. 
	 * If there is no cycle, return null.
	 */
	
	public static ListNode detectCycle(ListNode head){
		if(head == null){
			return null;
		}
		
		boolean isCycle = false;
		ListNode slow = head, fast = head;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				isCycle = true;
				break;
			}
		}
		
		if (!isCycle){
			return null;
		}
		
		// Attention here! Because maybe the tail doesn't link to the start of the linked list!!
		slow = head;
		while (slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
