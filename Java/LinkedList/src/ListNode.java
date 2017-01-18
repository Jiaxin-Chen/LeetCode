
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
		
		// If the linked list is cycle, uncomment this:
		/*
		boolean isCycle = true;
		if (isCycle){
			head.next = dummy.next;
		}*/
				
		return dummy.next;
	}

	public static void main(String[] args) {

		/*
		int[] nums = {1, 2, 3, 4, 5};
		ListNode head = inputLinkedList(nums);	
		outputLinkedList(Solution206.reverseList2(head));
		*/
		
		/*
		int[] nums = {1, 2, 6, 3, 4, 5, 6};
		int val = 6;
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution203.removeElements2(head, val));
		*/
		
		/*
		int[] nums = {1, 2, 3, 4, 5};
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution142.detectCycle(head));
		/*
		if(Solution141.hasCycle(head)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		*/
		
		/*
		int[] nums1 = {1, 3, 5, 7, 9};
		int[] nums2 = {2, 4, 6, 8, 10};
		ListNode l1 = inputLinkedList(nums1);
		ListNode l2 = inputLinkedList(nums2);
		outputLinkedList(Solution21.mergeTwoLists2(l1, l2));
		*/

		/*
		int[] nums = {2, 4, 1, 7, 3, 6, 5};
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution148.sortList(head));
		*/
		
		/*
		int[] nums = {1, 2, 3, 4, 5, 6};
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution24.swapPairs2(head));
		*/
		
		int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 5};
		ListNode head = inputLinkedList(nums);
		//outputLinkedList(Solution83.deleteDuplicates3(head));
		outputLinkedList(Solution82.deleteDuplicates(head));
	}

}
