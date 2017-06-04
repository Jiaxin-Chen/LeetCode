/*
19. Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
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

public class LC019{
	// Time Complexity: O(N)
	// Runtime: 17ms, beats 30.46%
	public ListNode removeNthFromEnd(ListNode head, int n){
		if(head == null)
			return null;
		if(n == 0)
			return head;

		ListNode helper = new ListNode(-1);
		helper.next = head;

		// Must let fast = helper and slow = helper, in case of we need remove the first node.
		// Corner case: [1], n = 1
		ListNode fast = helper, slow = helper;
		for(int i = 1; i <= n + 1; i++)
			fast = fast.next;

		while(fast != null){
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return helper.next;
	}

	// Faster version:
	// Time Complexity: O(N)
	// Runtime: 14ms, beats 84.62%
	public ListNode removeNthFromEnd2(ListNode head, int n){
		if(head == null)
			return null;
		if(n == 0)
			return head;

		ListNode helper = new ListNode(-1);
		helper.next = head;

		// Must let fast = helper and slow = helper, in case of we need remove the first node.
		// Corner case: [1], n = 1
		ListNode fast = helper, slow = helper;
		for(int i = 1; i <= n; i++)  // Make code faster
			fast = fast.next;

		while(fast.next != null){    // Make code faster
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return helper.next;
	}


	public static void main(String[] args){
		LC019 x = new LC019();
		int[] nums = {1};
		int n = 1;
		ListNode head = ListNode.input(nums);
		ListNode res = x.removeNthFromEnd(head, n);
		ListNode.output(res);
	}
}