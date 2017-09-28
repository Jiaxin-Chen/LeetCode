/*
Flattening a Linked List
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted. 
For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
*/

class ListNode {
	int val;
	ListNode down, right;
	ListNode(int v){
		val = v;
		down = null;
		right = null;
	}
}

public class Top2 {



	public ListNode flatten(ListNode head){
		if(head == null || head.right == null)
			return head;
		head.right = flatten(head.right);
		head = merge(head, head.right);
		return head;
	}

	public ListNode merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		ListNode res;
		if(list1.val < list2.val){
			res = list1;
			res.down = merge(list1.down, list2);
		} else {
			res = list2;
			res.down = merge(list1, list2.down);
		}
		return res;
	}

	public ListNode push(ListNode head, int v) {
		ListNode node = new ListNode(v);
		node.down = head;
		head = node;
		return head;
	}

	public void printList(ListNode head){
		ListNode cur = head;
		while(cur != null){
			System.out.print(cur.val + " ");
			cur = cur.down;
		}
		System.out.println();
	}

	public static void main(String[] args){
		Top2 solution = new Top2();

		
		ListNode head = new ListNode(30);
		head = solution.push(head, 8);
		head = solution.push(head, 7);
		head = solution.push(head, 5);

		head.right = solution.push(head.right, 20);
		head.right = solution.push(head.right, 10);

		head.right.right = solution.push(head.right.right, 50);
		head.right.right = solution.push(head.right.right, 22);
		head.right.right = solution.push(head.right.right, 19);

		head.right.right.right = solution.push(head.right.right.right, 45);
		head.right.right.right = solution.push(head.right.right.right, 40);
		head.right.right.right = solution.push(head.right.right.right, 35);
		head.right.right.right = solution.push(head.right.right.right, 28);

		head = solution.flatten(head);

		solution.printList(head);
	}
}





