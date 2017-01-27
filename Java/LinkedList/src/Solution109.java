
public class Solution109 {
	/* 109. Convert Sorted List to Binary Search Tree:
	 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	
	public static TreeNode sortedListToBST(ListNode head){
		if(head == null){
			return null;
		}
		return BST(head, null);
	}
	
	private static TreeNode BST(ListNode head, ListNode tail){
		if(head == tail){
			return null;
		}
		
		ListNode slow = head, fast = head;
		while(fast != tail && fast.next != tail){
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = BST(head, slow);
		node.right = BST(slow.next, tail);
		return node;
	}
}
