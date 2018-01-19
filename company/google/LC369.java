/*
369. Plus One Linked List

Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
*/

import java.util.*;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class LC369{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 1ms, beats 6.19%
	public ListNode plusOne(ListNode head){
		if(head == null){
			return null;
		}

		// Step 1: convert the ListNode into arraylist
		ListNode cur = head;
		List<Integer> digists = new ArrayList<>();
		while(cur != null){
			digists.add(cur.val);
			cur = cur.next;
		}

		// Step 2: find the idx where we don't have the carry bit from the tail
		int idx = -1;
		int size = digists.size();		
		for(int i = size - 1; i >= 0; i--){
			if(digists.get(i) != 9){
				idx = i;
				break;
			}
		}

		// Step 3: create dummy node, 
		ListNode dummy = new ListNode(1);
		cur = head;
		//if idx == -1, which is the case [9, 9] -> [1, 0, 0]
		if(idx == -1){
			dummy.next = head;
		// else we need find the carry bit position
		}else{
			dummy = head;
			int i = 0;
			while(i++ < idx){
				cur = cur.next;
			}
			cur.val += 1;
			cur = cur.next;
		}
		
		// Step 4: set the rest to 0
		while(cur != null){
			cur.val = 0;
			cur = cur.next;
		}

		return dummy;
	}

//---------------------------------------------------------------------
	// Optimization: Space Complexity
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 1ms, beats 6.19%
	public ListNode plusOne2(ListNode head){
		if(head == null){
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode lastNotNineNode = dummy;
		ListNode cur = head;

		// Step 1: find the lastNotNineNode
		while(cur != null){
			if(cur.val != 9){
				lastNotNineNode = cur;
			}
			cur = cur.next;
		}

		// Step 2: add 1 to the lastNotNineNode, if the lastNotNineNode = dummy, which is the case [9, 9] -> [1, 0, 0]
		lastNotNineNode.val++;
	
		// Step 3: set 0 to the left after lastNotNineNode
		cur = lastNotNineNode.next;
		while(cur != null){
			cur.val = 0;
			cur = cur.next;
		}

		// Step 4: if dummy.val = 1, which is the case [9, 9] -> [1, 0, 0], we need return dummy directly
		return dummy.val == 1 ? dummy : dummy.next;
	}

	public static void main(String[] args){
		LC369 x = new LC369();
		ListNode head = new ListNode(1);
		head.next = new ListNode(9);
		head.next.next = new ListNode(8);

		ListNode res = x.plusOne2(head);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
		
	}
}