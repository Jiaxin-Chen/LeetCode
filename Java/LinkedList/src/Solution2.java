
public class Solution2 {
	/* 2. Add Two Numbers:
	 * You are given two non-empty linked lists representing two non-negative integers. 
	 * The digits are stored in reverse order and each of their nodes contain a single digit. 
	 * Add the two numbers and return it as a linked list.
	 * 
	 * Input: 2->4->3 + 5->6->4
	 * Output:7->0->8
	 */
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode helper = new ListNode(0);
		ListNode head = helper;

		int sum = 0;
		while(l1 != null || l2 != null){
			sum /= 10;
			if (l1 != null){
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null){
				sum += l2.val;
				l2 = l2.next;				
			}
			head.next = new ListNode(sum % 10);
			head = head.next;
		}
		if (sum / 10 == 1){
			head.next = new ListNode(1);
		}
		
		return helper.next;
	}
}
