import java.util.*;
public class Solution445 {
	/* 445. Add Two Numbers II:
	 * You are given two non-empty linked lists representing two non-negative integers. 
	 * The most significant digit comes first and each of their nodes contain a single digit. 
	 * Add the two numbers and return it as a linked list.
	 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	 * 
	 * Input: (7->2->4->3) + (5->6->4)
	 * Output: 7->8->0->7
	 */
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		int sum = 0;
		ListNode helper = new ListNode(0);
		ListNode head = helper;
		
		while (l1 != null){
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null){
			s2.push(l2.val);
			l2 = l2.next;
		}
		
		while(!s1.isEmpty() || !s2.isEmpty()){
			sum /= 10;
			if(!s1.isEmpty()){
				sum += s1.pop();
			}
			if(!s2.isEmpty()){
				sum += s2.pop();
			}
			s3.push(sum % 10); 
			
		}
		if (sum / 10 == 1){
			s3.push(1);
		}
		
		while(!s3.isEmpty()){
			head.next = new ListNode(s3.pop());
			head = head.next;
		}
		return helper.next;
	}
}
