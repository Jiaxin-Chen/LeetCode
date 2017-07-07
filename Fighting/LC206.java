/*
206. Reverse Linked List

Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
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

public class LC206{
	// Iterative Version: 
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 34.57%
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;

		ListNode helper = new ListNode(-1);
		helper.next = head;
		ListNode prev = head, curr = head.next;

		while(curr != null){
			ListNode next = curr.next;
			helper.next = curr;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head.next = null;
		return helper.next;
	}


	// Recursive Version:
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 34.57%
	public ListNode reverseList2(ListNode head){
		return Helper(head, null);
	}

	private ListNode Helper(ListNode head, ListNode newHead){
		if(head == null)
			return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return Helper(next, head);
	}

	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		LC206 x = new LC206();
		ListNode head = ListNode.input(nums);
		ListNode.output(x.reverseList(head));
	}
}