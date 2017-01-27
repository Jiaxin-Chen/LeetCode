
public class Solution86 {
	/* 86. Partition List:
	 * Given a linked list and a value x, partition it such that all nodes less than x 
	 * come before nodes greater than or equal to x.
	 * 
	 * Input: 1->4->3->2->5->2, x = 3
	 * Output: 1->2->2->4->3->5
	 */
	
	public static ListNode partition(ListNode head, int x){
		if (head == null){
			return null;
		}
		ListNode smallerHead = new ListNode(0);
		ListNode smaller = smallerHead;
		ListNode largerHead = new ListNode(1);
		ListNode larger = largerHead;
		
		while(head != null){
			if (head.val < x){
				smaller.next = head;
				smaller = smaller.next;
			}else{
				larger.next = head;
				larger = larger.next;
			}
			
			head = head.next;
		}
		
		larger.next = null;  //Attention!!! Important here!!
		smaller.next = largerHead.next;
		return smallerHead.next;
	}
}
