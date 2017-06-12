/*
82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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

public class LC082{
	// Time Compelxity: O(N)
	// Runtime: 1ms, beats 22.41%
	public ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null)
			return head;

		ListNode helper = new ListNode(-1);
		helper.next = head;
		ListNode prev = helper, cur = head;

		while(cur != null){
			while(cur.next != null && cur.val == cur.next.val)
				cur = cur.next;
			// Check if prev is exactly equal to cur, not only the value!!!
			if(prev.next == cur)
				prev = prev.next;
			else
				prev.next = cur.next;
			cur = cur.next;
		}
		return helper.next;
	}


	public static void main(String[] args){
		LC082 x = new LC082();
		int[] nums = {1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 6};
		ListNode head = ListNode.input(nums);
		ListNode res = x.deleteDuplicates(head);
		ListNode.output(res);
	}

}