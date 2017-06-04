/*
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
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

public class LC021{
	// Iterative Version:
	// Time Complexity: O(N)
	// Runtime: 17ms, beats 36.64%
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;

		ListNode helper = new ListNode(-1);
		ListNode cur = helper;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				cur.next = l1;
				l1 = l1.next;
			}else{
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if(l1 != null)
			cur.next = l1;
		if(l2 != null)
			cur.next= l2;

		return helper.next;
	}

	// Recursive Version:
	// Time Complexity: O(N)
	// Runtime: 22ms, beats 7.90%
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;

		ListNode head;
		if(l1.val < l2.val){
			head = l1;
			head.next = mergeTwoLists2(l1.next, l2);
		}else{
			head = l2;
			head.next = mergeTwoLists2(l1, l2.next);
		}

		return head;
	}

	public static void main(String[] args){
		LC021 x = new LC021();
		int[] nums1 = {1, 3, 5, 7, 9}, nums2 = {2, 4, 6, 8, 10};
		ListNode l1 = ListNode.input(nums1), l2 = ListNode.input(nums2);
		ListNode res = x.mergeTwoLists2(l1, l2);
		ListNode.output(res);
	}

}