
public class Solution23 {
	/* 23. Merge k Sorted Lists:
	 * Merge k sorted linked lists and return it as one sorted list. 
	 * Analyze and describe its complexity.
	 */
	
	public static ListNode mergeKLists(ListNode[] lists){
		return merge(lists, 0, lists.length - 1);
	}
	
	private static ListNode merge(ListNode[] lists, int start, int end){
		if (start > end){
			return null;
		}
		if (start == end){
			return lists[start];
		}
		
		int mid = (start + end) / 2;
		ListNode left = merge(lists, start, mid);
		ListNode right = merge(lists, mid + 1, end);
		ListNode helper = new ListNode(0);
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
		cur.next = (left != null) ? left : right;
		
		return helper.next;
	}
}
