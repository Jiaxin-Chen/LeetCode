/*
234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

Notes: 
Actually Reversing a list is not considered "O(1) space"!!!
Reversing a singly linked list requires writing to O(n) memory space.
 */

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}

	public static ListNode input(int[] nums){
		if(nums.length == 0)
			return null;

		ListNode helper = new ListNode(-1);
		ListNode cur = helper;
		for(int i = 0; i < nums.length; i++){
			cur.next = new ListNode(nums[i]);
			cur = cur.next;
		}
		return helper.next;
	}

	public static void output(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}


public class LC234{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 2ms, beats 35.99%
	public boolean isPalindrome(ListNode head){
		if(head == null || head.next == null)
			return true;

		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode head2 = reverse(slow.next);
		slow.next = null;

		while(head != null && head2 != null){
			if(head.val != head2.val)
				return false;
			head = head.next;
			head2 = head2.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head){
		ListNode prev = null, next = null;
		while(head != null){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}
}
