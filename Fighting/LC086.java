/*
86. Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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

public class LC086{
	// You need finish it in one pass!!!
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 7.95%
	public ListNode partition(ListNode head, int x){
		if(head == null || head.next == null)
			return head;

		ListNode helper1 = new ListNode(-1), helper2 = new ListNode(-1);
		ListNode smaller = helper1, larger = helper2;
		while(head != null){
			if(head.val < x){
				smaller.next = head;
				smaller = smaller.next;
				//System.out.println("smaller = " + smaller.val);
			}else{
				larger.next = head;
				larger = larger.next;
				//System.out.println("larger = " + larger.val);
			}
			head = head.next;
		}
		larger.next = null;  // Avoid Cycled linked list
		smaller.next = helper2.next;

		return helper1.next;
	}


	public static void main(String[] args){
		LC086 x = new LC086();
		int[] nums = {1, 4, 3, 2, 5, 2};
		int k = 3;
		ListNode head = ListNode.input(nums);
		ListNode res = x.partition(head, k);
		ListNode.output(res);
	}
}