/*
61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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

public class LC061{
	// Time Complexity: O(N)
	// Runtime: 18ms, beats 43.02%
	public ListNode rotateRight(ListNode head, int k){
		if(head == null || k == 0)
			return head;
		
		ListNode helper = new ListNode(-1);
		helper.next = head;
		ListNode tail = head;
		int len = 1;
		while(tail.next != null){
			tail = tail.next;
			len++;
		}

		k = k % len;
		if(k == 0)
			return head;

		ListNode cur = helper;
		for(int i = 0; i < len - k; i++){
			cur = cur.next;
		}
		helper.next = cur.next;
		cur.next = null;
		tail.next = head;

		return helper.next;
	}

	public static void main(String[] args){
		LC061 x = new LC061();
		int[] nums = {1, 2, 3, 4, 5}; 
		ListNode head = ListNode.input(nums);
		int k = 2;
		ListNode res = x.rotateRight(head, k);
		ListNode.output(res);
	}
}