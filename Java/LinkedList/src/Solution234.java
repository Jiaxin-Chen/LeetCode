
public class Solution234 {
	/* 234. Palindrome Linked List:
	 * Given a singly linked list, determine if it is a palindrome.
	 * 
	 * Input: 1->2->3->2->1
	 * Output: True
	 * Complexity: Time O(N), Space O(1)
	 */
	
	public static boolean isPalindrome(ListNode head){
		
		// Attention here!!! It's true if the linked list is null!!!
		if(head == null){
			return true;
		}
		
		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = slow.next;
		
		ListNode right = null;
		while(slow != null){
			ListNode next = slow.next;
			slow.next = right;
			right = slow;
			slow = next;
		}
		
		while(right != null){
			if(right.val != head.val){
				return false;
			}
			right = right.next;
			head = head.next;
		}
		return true;
	}
	
}
