
public class Solution61 {
	/* 61. Rotate List:
	 * Given a list, rotate the list to the right by k places, where k is non-negative.
	 * 
	 * Input: 1->2->3->4->5->NULL, k = 2
	 * Output: 4->5->1->2->3->NULL
	 */
	
	public static ListNode rotateRight(ListNode head, int k){
		if (head == null){
			return null;
		}
		
		int length = 1;
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode tmp = head;
		while(tmp.next != null){
			tmp = tmp.next;
			length++;
		}
		
		k = k % length;
		if(k == 0){
			return head;
		}else{
			ListNode cur = helper;
		
			for(int i = 0; i < length - k; i++){
				cur = cur.next;
			}
		
			helper.next = cur.next;
			tmp.next = head;
			cur.next = null;
		}
		return helper.next;
		
	}
}
