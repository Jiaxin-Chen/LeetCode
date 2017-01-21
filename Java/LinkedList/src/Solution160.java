
public class Solution160 {
	/* 160. Intersection of Two Linked Lists:
	 * Write a program to find the node at which the intersection of two singly linked lists begins.
	 * If the two linked lists have no intersection at all, return null.
	 * The linked lists must retain their original structure after the function returns.
	 * You may assume there are no cycles anywhere in the entire linked structure.
	 * 
	 * Input: 1->3->5->6->7->8->9  2->4->6->7->8->9
	 * Output: 6->7->8->9
	 * Complexity: Time O(N), Space O(1)
	 */
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if (headA == null || headB == null){
			return null;
		}
		
		int lengthA = 1, lengthB = 1;
		ListNode tailA = headA, tailB = headB;
		while(tailA.next != null){
			tailA = tailA.next;
			lengthA++;
		}
		while(tailB.next != null){
			tailB = tailB.next;
			lengthB++;
		}
		System.out.println(lengthA + " " + lengthB);
		
		
		if(tailA != tailB){
			return null;
		}
		
		ListNode longer = lengthA > lengthB ? headA : headB;
		ListNode shorter = lengthA > lengthB ? headB: headA;
		
		for (int i = 0; i < Math.abs(lengthA - lengthB); i++){
			longer = longer.next;
		}
			
		while(shorter != longer){
			shorter = shorter.next;
			longer = longer.next;
		}
		return longer;
	}
	
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB){
		if(headA == null || headB == null) return null;
	    
	    ListNode a = headA;
	    ListNode b = headB;
	    
	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }
	    
	    return a;
	}
}
