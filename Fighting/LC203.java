/*
203. Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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

public class LC203{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 64.31%
	public ListNode removeElements(ListNode head, int val){
		if(head == null)
			return head;

		ListNode helper = new ListNode(-1);
		helper.next = head;
		ListNode prev = helper;

		while(head != null){
			if(head.val == val){
				prev.next = head.next;
			}else{
				prev = head;
			}
			head = head.next;
		}
		return helper.next;
	}

	public static void main(String[] args){
		LC203 x = new LC203();
		int[] nums = {1, 2, 6, 3, 6, 1, 6};
		ListNode head = ListNode.input(nums);
		int val = 6;
		ListNode res = x.removeElements(head, val);
		ListNode.output(res);
	}
}