/*
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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

public class LC023{
	// Iterative Version:
	// Time Complexity: O(NlogN)
	// Runtime: 20ms, beats 60.05%
	public ListNode mergeKLists(ListNode[] lists){
		if(lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			@Override
			public int compare(ListNode node1, ListNode node2){
				if(node1.val < node2.val)
					return -1;
				else if(node1.val == node2.val)
					return 0;
				else 
					return 1;
			}
		});

		ListNode helper = new ListNode(-1);
		ListNode cur = helper;

		// Sort the head of all the lists first.
		for(ListNode head : lists){
			if(head != null)
				queue.add(head);
		}

		while(!queue.isEmpty()){
			cur.next = queue.poll();
			cur = cur.next;

			if(cur.next != null)
				queue.add(cur.next);
		}
		return helper.next;
	}

	public static void main(String[] args){
		LC023 x = new LC023();

		int[] nums1 = {1, 5, 9}, nums2 = {2, 7}, nums3 = {0, 5, 6}, nums4 = {3};
		ListNode l1 = ListNode.input(nums1), l2 = ListNode.input(nums2);
		ListNode l3 = ListNode.input(nums3), l4 = ListNode.input(nums4);
		ListNode[] lists = {l1, l2, l3, l4};

		ListNode res = x.mergeKLists(lists);
		ListNode.output(res);
	}




}