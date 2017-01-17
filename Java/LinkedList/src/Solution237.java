
public class Solution237 {
	/* 237. Delete Node in a Linked List:
	 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	 * 
	 * Input: node 3, linked list: 1 -> 2 -> 3 -> 4 
	 * Output: 1 -> 2 -> 4
	 */
	
	public static void deleteNode(ListNode node){
		/* We cannot delet current node because we don't have the previous node's pointer,
		 * but we can copy the node.next.val and delete node.next!!!!
		 */
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
