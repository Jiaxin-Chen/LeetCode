 /*
 24. Swap Nodes in Pairs

 Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed.
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

public class LC024{
	// Time Complexity: O(N)
	// Runtime: 5ms, beats 30.17%
	public ListNode swapPairs(ListNode head){
		if(head == null || head.next == null)
			return head;

		ListNode helper = new ListNode(-1);
		helper.next = head;
		ListNode prev = helper;

		while(head != null && head.next != null){
			ListNode next = head.next;
			//System.out.println("head = " + head.val + ", prev = " + prev.val + ", next = " + next.val);
			prev.next = next;
			head.next = next.next;
			next.next = head;
			prev = head;
			head = head.next;
		}
		return helper.next;
	}


	public static void main(String[] args){
		LC024 x = new LC024();
		int[] nums1 = {1, 2, 3, 4, 5};
		ListNode head = ListNode.input(nums1);
		ListNode res = x.swapPairs(head);
		ListNode.output(res);
	}
}