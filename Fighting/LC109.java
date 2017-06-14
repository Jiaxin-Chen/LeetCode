/*
109. Convert Sorted List to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}


public class LC109{
	// Time Complexity: O(2^N)
	// Runtime: 1ms, beats 53.66%
	public TreeNode sortedListToBST(ListNode head){
		if(head == null)
			return null;
		return Helper(head, null);
	}

	private TreeNode Helper(ListNode head, ListNode tail){
		if(head == tail)
			return null;

		ListNode slow = head, fast = head;

		while(fast != tail && fast.next != tail){
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = Helper(head, slow);
		root.right = Helper(slow.next, tail);
		return root;
	}



}