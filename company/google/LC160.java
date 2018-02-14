/*
160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	// Time Complexity: O(M + N)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null){
            return null;
        }
        // assume lenA = a+c, lenB = b+c, a+c+b = b+c+a
        ListNode curA = headA, curB = headB;
        while(curA != curB){
            curA = (curA == null) ? headB : curA.next;  // go through a+c+b part
            curB = (curB == null) ? headA : curB.next;  // go through b+c+a part
        }
        return curA;
    }
}