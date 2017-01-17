
public class Solution141 {
	/* 141. Linked List Cycle:
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * Complexity: O(1) space
	 */
	
	public static boolean hasCycle(ListNode head){
		if (head == null){
			return false;
		}
		
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast){
				return true;
			}
		}
		return false;
	}
}
