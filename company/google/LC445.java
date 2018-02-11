/*
445. Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

import java.util.*;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class LC445{
	// Time Complexity: O(N)
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		
		int sum = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) {
				sum += s1.pop();
			}
			if (!s2.isEmpty()) {
				sum += s2.pop();
			}
			s3.push(sum % 10);
			sum = sum / 10;
		}
		if(sum == 1){
			s3.push(1);
		}
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;

		while(!s3.isEmpty()){
			head.next = new ListNode(s3.pop());
			head = head.next;
		}

		return dummy.next;
	}

	public static void main(String[] args){
		LC445 x = new LC445();
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(2);

		ListNode res = x.addTwoNumbers(l1, l2);
		while(res != null){
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}