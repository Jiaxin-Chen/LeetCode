/*
141. Linked List Cycle

Given a linked list, determine if it has a cycle in it.

1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 2

Follow up:
Can you solve it without using extra space?
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

public class LC141{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 7.24%
	public boolean hasCycle(ListNode head){
		if(head == null)
			return false;

		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
}

