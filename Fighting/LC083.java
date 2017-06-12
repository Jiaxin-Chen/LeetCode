/*
83. Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

import java.util.*;

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

public class LC083{
	// Recursive Version:
	// Time Complexity: 
	// Runtime: 1ms, beats 18.36%
	public ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}


	// Iterative Version:
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 18.36%
	public ListNode deleteDuplicates2(ListNode head){
		if(head == null || head.next == null)
			return head;

		ListNode prev = head, cur = head.next;
		while(cur != null){
			if(cur.val == prev.val){
				prev.next = cur.next;
			}else{
				prev = prev.next;
			}
			cur = cur.next;
		}
		return head;
	}

	public static void main(String[] args){
		LC083 x = new LC083();
		int[] nums = {1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 6};
		ListNode head = ListNode.input(nums);
		ListNode res = x.deleteDuplicates(head);
		ListNode.output(res);
	}
}