/*
160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
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

public class LC160{
	public ListNode getIntersectionNode(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null)
			return null;
		ListNode cur1 = head1, cur2 = head2;

		// Don't have to worry the difference of len1 and len2, 
		// because we can go through len1 + len2 for both cur1 and cur2 to find the intersect node.
		while(cur1 != cur2){
		 	cur1 = (cur1 == null) ? head2 : cur1.next;
		 	cur2 = (cur2 == null) ? head1 : cur2.next;
		}
		return cur1;
	}

	public static void main(String[] args){
		LC160 x = new LC160();
		int[] nums1 = {1, 2, 3, 6, 7, 8};
		int[] nums2 = {5, 6, 7, 8};
		ListNode head1 = ListNode.input(nums1);
		ListNode head2 = ListNode.input(nums2);
		ListNode res = x.getIntersectionNode(head1, head2);
		ListNode.output(res);
	}
}