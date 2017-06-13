/*
92. Reverse Linked List II

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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


public class LC092{
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 17.99%
	public ListNode reverseBetween(ListNode head, int m, int n){
		if(head == null || head.next == null || m == n)
			return head;

		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode prev = helper;
		int count = n - m;

		while(--m > 0){
			prev = prev.next;
		}
		ListNode cur = prev.next;
		
		while(count-- > 0){
			ListNode next = cur.next; 
			cur.next = next.next;
			next.next = prev.next;
			prev.next = next;
		}
		return helper.next;
	}


	public static void main(String[] args){
		LC092 x = new LC092();
		int[] nums = {1, 2, 3, 4, 5};
		int m = 2, n = 4;
		ListNode head = ListNode.input(nums);
		ListNode res = x.reverseBetween(head, m, n);
		ListNode.output(res);
	}
}