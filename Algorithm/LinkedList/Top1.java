class ListNode {
	int val;
	ListNode next;
	ListNode (int v) {
		val = v;
		next = null;
	}

	public static ListNode input(int[] nums){
		if(nums.length == 0)
			return null;

		ListNode helper = new ListNode(-1);
		ListNode cur = helper;
		for(int i = 0; i < nums.length; i++){
			cur.next = new ListNode(nums[i]);
			cur = cur.next;
		}
		return helper.next;
	}

	public static void output(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}


public class Top1 {
	
	public ListNode printMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args){
		Top1 solution = new Top1();
		int[] nums = {1, 2, 3, 4, 5};
		ListNode head = ListNode.input(nums);
		ListNode res = solution.printMiddle(head);
		System.out.println(res.val);
	}
}