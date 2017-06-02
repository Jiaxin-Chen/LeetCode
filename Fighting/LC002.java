/*
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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

public class LC002{
	// Time Complexity: O(N)
	// Runtime: 53ms, beats 75.18%
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode helper = new ListNode(-1);
		if(l1 == null && l2 == null)
			return helper.next;
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;

		ListNode cur = helper;
		int sum = 0;
		while(l1 != null || l2 != null){
			sum /= 10;
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
		}
		if(sum / 10 == 1){
			cur.next = new ListNode(1);
		}

		return helper.next;
	}

	public static void main(String[] args){
		LC002 x = new LC002();
		int[] nums1 = {2, 4, 3}, nums2 = {5, 6, 4};
		ListNode l1 = ListNode.input(nums1), l2 = ListNode.input(nums2);
		ListNode res = x.addTwoNumbers(l1, l2);
		ListNode.output(res);
	}
}