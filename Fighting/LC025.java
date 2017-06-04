/*
25. Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
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

public class LC025{
	// Time Complexity: O()
	// Runtime: 9ms, beats 31.98%
	public ListNode reverseKGroup(ListNode head, int k){
		if(head == null || head.next == null || k == 1)
			return head;

		ListNode helper = new ListNode(-1);
		ListNode prev = helper;
		helper.next = head;
		ListNode cur = head;
		int len = 0;
		while(cur != null){
			cur = cur.next;
			len++;
		}

		int group = len / k;
		for(int i = 0; i < group; i++){
			for(int j = 1; j < k; j++){
				ListNode next = head.next;
				head.next = next.next;
				next.next = prev.next;
				prev.next = next;
			}
			prev = head;
			head = head.next;
		}

		return helper.next;
	}

	public static void main(String[] args){
		LC025 x = new LC025();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		ListNode head = ListNode.input(nums);
		int k = 3;
		ListNode res = x.reverseKGroup(head, k);
		ListNode.output(res);
	}

}