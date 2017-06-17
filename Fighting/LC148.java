/*
148. Sort List

Sort a linked list in O(n log n) time using constant space complexity.
*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class LC148{
	// Time Complexity: O(N)
	// Runtime: 9ms, beats 39.08%
	public ListNode sortList(ListNode head){
		if(head == null || head.next == null)
			return head;

		ListNode mid = getMiddle(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
	}

	private ListNode getMiddle(ListNode head){
		if(head.next == null)
			return head;
		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode merge(ListNode left, ListNode right){
		if(left == null)
			return right;
		if(right == null)
			return left;

		ListNode helper = new ListNode(0);
		ListNode cur = helper;

		while(left != null && right != null){
			if(left.val < right.val){
				cur.next = left;
				left = left.next;
			}else{
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		if(left != null){
			cur.next = left;
		}else{
			cur.next = right;
		}
		return helper.next;
	}
}