
public class Solution25 {
	/* 25. Reverse Nodes in k-Group:
	 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
	 * k is a positive integer and is less than or equal to the length of the linked list. 
	 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
	 * 
	 * Input: 1->2->3->4->5->NULL
	 * Output: 2->1->4->3->5->NULL(k = 2), 3->2->1->4->5->NULL(k = 3)
	 */
	
	public static ListNode reverseKGroups(ListNode head, int k){
		if (head == null || head.next == null || k == 1){
			return null;
		}
		
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode cur = head, prev = helper;
		int length = 1;
		while(cur.next != null){
			cur = cur.next;
			length++;
		}
		cur = head;
		for (int i = 0; i < length / k; i ++){
			for (int j = 0; j < k - 1; j++){
				ListNode next = cur.next;
				cur.next = next.next;
				next.next = prev.next;
				prev.next = next;
				
			}
			prev = cur;
			cur = cur.next;
		}
		return helper.next;
		
	}
}
