
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
		
		/*
		int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 5};
		ListNode head = inputLinkedList(nums);
		//outputLinkedList(Solution83.deleteDuplicates3(head));
		outputLinkedList(Solution82.deleteDuplicates(head));
		*/
		
		/*
		int[] nums1 = {1, 3, 5, 6, 7, 8, 9};
		int[] nums2 = {2, 4, 6, 7, 8, 9};
		ListNode headA = inputLinkedList(nums1);
		ListNode headB = inputLinkedList(nums2);
		outputLinkedList(Solution160.getIntersectionNode2(headA, headB));
		*/
		
		/*
		int [] nums = {1, 2, 3, 4, 3, 2, 1};
		ListNode head = inputLinkedList(nums);
		if(Solution234.isPalindrome(head)){
			System.out.println("True");
		}
		*/
		
		/*
		int[] nums = {1,2};//{1, 2, 3, 4, 5};
		int n = 2;
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution19.removeNthFromEnd(head, n));
		*/
		
		/*
		int[] nums = {3, 2, 4, 1, 5};
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution147.insertionSortListNode(head));
		*/
		
		/*
		int[] nums = {1, 2, 3, 4, 5};
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution328.oddEvenList(head));
		*/
		
		/*
		int[] nums1 = {7, 2, 4, 3};
		int[] nums2 = {5, 6, 4};
		ListNode l1 = inputLinkedList(nums1);
		ListNode l2 = inputLinkedList(nums2);
		//outputLinkedList(Solution2.addTwoNumbers(l1, l2));
		outputLinkedList(Solution445.addTwoNumbers(l1, l2));
		*/
		
		/*
		int[] nums = {1,3 ,4, 6, 3, 4, 5};
		int x = 4;
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution86.partition(head, x));
		*/
		
		/*
		int[] nums = {1, 2, 3, 4, 5};
		int k = 1;
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution61.rotateRight(head, k));
		*/
		
		/*
		int[] nums = {1, 2, 3, 4, 5, 6};
		ListNode head = inputLinkedList(nums);
		Solution143.reorderList(head);
		outputLinkedList(head);
		*/
		
		/*
		int[] nums = {1, 2, 3, 4};
		int m = 1, n = 3;
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution92.reverseBetween(head, m, n));
		*/
		
		/*
		int[] nums = {1, 2, 3, 4, 5};
		int k = 2;
		ListNode head = inputLinkedList(nums);
		outputLinkedList(Solution25.reverseKGroups(head, k));
		*/
		
		
	}

}
