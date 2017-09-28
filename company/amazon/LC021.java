/*
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

class LC021{
	// Time Complexity: O(N)
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;

		ListNode helper = new ListNode(-1);
		ListNode cur = helper;

		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				cur.next = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if(l1 != null)
			cur.next = l1;
		if(l2 != null)
			cur.next = l2;

		return helper.next;
	}

	public static void main(String[] args){

		LC021 x = new LC021();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(6);

		ListNode res = x.mergeTwoLists(l1, l2);

		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}

	}
}