/*
138. Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
 */

//Consider l1 as a node on the 1st list and l2 as the corresponding node on 2nd list.
// Step 1:
// Build the 2nd list by creating a new node for each node in 1st list. 
// While doing so, insert each new node after it's corresponding node in the 1st list.
// Step 2:
// The new head is the 2nd node as that was the first inserted node.
// Step 3:
// Fix the random pointers in the 2nd list: (Remember that l1->next is actually l2)
// l2->random will be the node in 2nd list that corresponds l1->random, 
// which is next node of l1->random.
// Step 4:
// Separate the combined list into 2: Splice out nodes that are part of second list. 
// Return the new head that we saved in step 2.

class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x){
		this.label = x;
	}
}

public class LC138{
	// Time Complexity: O(N)
	// Runtime: 2ms, beats 70.96%
	public RandomListNode copyRandomList(RandomListNode head){
		if(head == null)
			return head;
		RandomListNode copyHead, l1, l2 = null;
		for(l1 = head; l1 != null; l1 = l1.next.next){
			l2 = new RandomListNode(l1.label);
			l2.next = l1.next;
			l1.next = l2;
		}

		copyHead = head.next;
		for(l1 = head; l1 != null; l1 = l1.next.next){
			if(l1.random != null)
				l1.next.random = l1.random.next;
		}

		for(l1 = head; l1 != null; l1 = l1.next){
			l2 = l1.next;
			l1.next = l2.next;
			if(l2.next != null)
				l2.next = l2.next.next;
		}

		return copyHead;
	}
}