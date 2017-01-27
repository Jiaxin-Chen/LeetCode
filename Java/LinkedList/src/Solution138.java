
class RandomListNode {
   int label;
   RandomListNode next, random;
   RandomListNode(int x) { this.label = x; }
};

public class Solution138 {
	/* 138: Copy List with Random Pointer:
	 * A linked list is given such that each node contains an additional random pointer 
	 * which could point to any node in the list or null.
	 * Return a deep copy of the list.
	 */
	
	public static RandomListNode copyRandomList(RandomListNode head){
		if (head == null){
			return null;
		}
		
		RandomListNode cur = head;
		while(cur != null){
			RandomListNode node = new RandomListNode(cur.label);
			node.next = cur.next;
			cur.next = node;
			cur = cur.next.next;
		}
		
		cur = head;
		while(cur != null){
			if(cur.random != null){
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		
		RandomListNode helper = new RandomListNode(0);
		RandomListNode cur2 = helper;
		cur = head;
		while(cur != null){
			cur2.next = cur.next;
			cur2 = cur2.next;
			cur.next = cur.next.next;
			cur = cur.next;
		}
		return helper.next;
	}
}
