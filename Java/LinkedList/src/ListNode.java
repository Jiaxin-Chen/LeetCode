
public class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x){
		this.val = x;
		this.next = null;
	}
	
	public static int getLength(ListNode head){
		int length = 0;
		while (head != null){
			head = head.next;
			length++;
		}
		return length;
	}
	
	public static void outputLinkedList(ListNode head){
		if (head == null){
			System.out.println("No LinkedList Exist!");
		}else{
			System.out.println("Output LinkedList:");
			while(head != null){
				System.out.print(head.val + "->");
				head = head.next;
			}
			System.out.println("null");
		}
	}
	
	public static ListNode inputLinkedList(int[] nums){
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		for(int i = 0; i < nums.length; i++){
			head.next = new ListNode(nums[i]);
			head = head.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 4, 5};
		ListNode head = inputLinkedList(nums);
		
		outputLinkedList(Solution206.reverseList2(head));
		
	}

}
