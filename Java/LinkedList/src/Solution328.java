
public class Solution328 {
	/* 328. Odd Even Linked List:
	 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
	 * Please note here we are talking about the node number and not the value in the nodes.
	 * 
	 * Input: 1->2->3->4->5->NULL
	 * Output: 1->3->5->2->4->NULL
	 * Complexity: Time O(N), Space O(1)
	 */
	
	public static ListNode oddEvenList(ListNode head){
		if (head == null || head.next == null){
			return head;
		}

		ListNode odd = head, even = head.next, evenHead = even;
		
		while(even != null && even.next != null){
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;

		return head;
		
	}
}
