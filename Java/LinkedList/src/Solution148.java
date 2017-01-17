
public class Solution148 {
	/* 148. Sort List:
	 * Complexity: Time O(NlogN), Space O(1)
	 */
	
	public static ListNode sortList(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode mid = getMiddle(head);
		//System.out.println(mid.val);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
	}
	
	private static ListNode getMiddle(ListNode head){
		if (head == null){
			return null;
		}
		
		//Attention! IT IS fast = head.next;  NOT fast = head;
		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static ListNode merge(ListNode l1, ListNode l2){
		if (l1 == null && l2 == null){
			return null;
		}
		
		if (l1 == null){
			return l2;
		}
		
		if (l2 == null){
			return l1;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		while (l1 != null && l2 != null){
			if(l1.val <= l2.val){
				head.next = l1;
				l1 = l1.next;
			}else{
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		if (l1 != null){
			head.next = l1;
		}else{
			head.next = l2;
		}
		
		return dummy.next;
	}
}
