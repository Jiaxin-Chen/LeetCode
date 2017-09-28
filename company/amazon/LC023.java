/*
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

public class LC023{
	/*Time complexity : O(Nlog k)where k is the number of linked lists.
	We can merge two sorted linked list in O(n) time where n is the total number of nodes in two lists.
	Sum up the merge process and we can get: O(∑i=1 log_2^k N)=O(Nlogk)

	Space complexity : O(1)
	We can merge two sorted linked lists in O(1) space.
	*/
	public ListNode mergeKLists(ListNode[] lists){
		return merge(lists, 0, lists.length - 1);
	}

	private ListNode merge(ListNode[] lists, int start, int end){
		if(start > end)
			return null;

		if(start == end)
			return lists[start];

		int mid = start + (end - start) / 2;

		ListNode left = merge(lists, start, mid);
		ListNode right = merge(lists, mid + 1, end);

		ListNode helper = new ListNode(-1);
		ListNode cur = helper;
		while(left != null && right != null){
			if(left.val < right.val){
				cur.next = left;
				left = left.next;
			}else{
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		if(left != null)
			cur.next = left;
		if(right != null)
			cur.next = right;

		return helper.next;
	}

	public static void main(String[] args){
		LC023 x = new LC023();

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(9);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(8);

		ListNode l3 = new ListNode(3);
		l3.next = new ListNode(4);
		l3.next.next = new ListNode(7);

		ListNode[] lists = {l1, l2, l3};

		ListNode res = x.mergeKLists(lists);

		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}