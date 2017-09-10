
import java.util.*;

public class JavaMethodsSummary{
	public void StringMethods(){
		String s = "  0123 123  0";
		String str = s.trim();			 // "0123 123  0", trim only the leading white space of the string
		String str2 = str.substring(0, 4); // "0123", [begigIdx, endIdx)
		String str3 = str.substring(3);    // "3 123 0", [beginIdx, str3.length()-1)
		
		char ch = str.charAt(0);  	    // '0'
		int len = str.length();         // 10
		int idx1 = str.indexOf('2');         // 2, search the idx from the begining
		int idx2 = str.indexOf('2', 5);      // 6, search the idx from idx=5
		int idx3 = str.indexOf("23");		 // 2
		int idx4 = str.indexOf("23", 5);     // 6, search the idx from idx=5
		int idx5 = str.lastIndexOf('2');     // 6
		int idx6 = str.lastIndexOf('2', 3);  // 2, search the idx backward from idx = 3

		boolean isEqual = str.equals("b");   //false
		boolean isStartsWith = str.startsWith("0123"); // true
		boolean isStartsWith2 = str.startsWith("0123", 2); // false, search the prefix from the idx = 2

		char[] chs = str.toCharArray(); // "0123 123  0"

		Integer a = Integer.valueOf(str2); // 123, Returns an Integer instance representing the specified int value.
		int b = Integer.parseInt(str2);    // 123. Attention: it's not 0123!!!
		String str4 = String.valueOf(a);

		//System.out.println(str4);
	}

	public void StringBuilderMethods() {
		StringBuilder sb = new StringBuilder();
		sb.append("bcdefg");  // bcdefg
		sb.insert(0, "a"); // abcdefg
		sb.deleteCharAt(sb.length() - 1); //abcdef
		sb.delete(3, 5);   // abcf, [beginIdx, endIdx)
		sb.reverse();      // fcba
		sb.toString();
		//System.out.println(sb);
	}

	public int[] ArrayMethods() {
		int[] a = new int[10]; 
		char[] b = {'a', 'b'};
		int[][] c = new int[10][10];
		int[] d = {3, 5, 1, 6, 8, 2, 4, 7, 9};
		int m = a.length, n = c[0].length;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		Arrays.sort(d);  //Time Complexity: O(NlogN)

		//System.out.println(d); // Printing array directly can only output the address of the array
		for(int i = 0; i < d.length; i++) {
			//System.out.println(d[i]);
		}
		return new int[]{1, 2, 3, 4, 5}; // Attention: int[] is fine, not int[len] !!!
	}

	public void ListMethods() {
		// add, addAll is shallow copy
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer> > nestedList = new ArrayList<List<Integer>>();
		list.add(1); list.add(3); list.add(2); list.add(5); list.add(4); // [1, 3, 2, 5, 4]

		List<Integer> list3 = new ArrayList<Integer>(list);  // Create a new instances of arraylist
		List<Integer> list4 = list; // Just copy reference of list, not the instances. They both refer to the same object as list, when list is modified, list4 changed as well;

		list.add(0, -1);  // list = [-1, 1, 3, 2, 5, 4], (idx, element)
		nestedList.add(list3); // nestedList = [1, 3, 2, 5, 4]
		nestedList.add(new ArrayList<Integer>());  // nestedList = [[1, 3, 2, 5, 4], []]
		nestedList.size();   	 // 2
		nestedList.get(0).size(); //6
		nestedList.get(0).remove(nestedList.get(0).size() - 1);  // nestedList = [[1, 3, 2, 5], []], list3 = [1, 3, 2, 5]

		Collections.sort(list); 		// list = [-1, 1, 2, 3, 4, 5]
		nestedList.get(1).addAll(list);  // nestedList = [[1, 3, 2, 5], [-1, 1, 2, 3, 4, 5]]
										 // addAll just copy the reference of list, it doesn't create the copies of the instances these references refer to.
										 // when list is modified, nestedList.get(1) changed as well.
		Collections.sort(list, Collections.reverseOrder());  // list and list4 = [5, 4, 3, 2, 1, -1], 
															  // because they refer to the same object

		Collections.sort(list3, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//return o1 - o2;  // 0 -> 1, list3 = [1, 2, 3, 5], nestedList = [[1, 2, 3, 5], [-1, 1, 2, 3, 4, 5]]
				 return o2 - o1;   // 1 -> 0, list3 = [5, 3, 2, 1], nestedList = [[5, 3, 2, 1], [-1, 1, 2, 3, 4, 5]]
				 				   // but why does nestedList.get(1) still = [-1, 1, 2, 3, 4, 5] rather than [5, 4, 3, 2, 1, -1]?
			}
		});
		//System.out.println(nestedList); // We can print list directly, but we cannot print array!!!
	}

	public void StackMethods() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0); stack.push(1); stack.push(2); stack.push(3); // stack = [0, 1, 2, 3]
		stack.pop(); stack.pop(); // pop 3, 2 orderly, stack = [0, 1]
		int num = stack.peek();   // 1
		boolean flag = stack.isEmpty();
		int size = stack.size(); // 2

		//System.out.println(size);
	}

	public void QueueMethods() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0); queue.add(1); queue.add(2); queue.add(3);   // queue = [0, 1, 2, 3]
		queue.remove();  // queue = [1, 2, 3]
		queue.remove();  // queue = [2, 3]
		int num = queue.peek();    // 2
		int size = queue.size();
		if (!queue.isEmpty()) { }

		//System.out.println(num);
	}

	public void DequeMethods() {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.offer(0); deque.offer(1); deque.offer(2); deque.offer(3);  // deque = [0, 1, 2, 3]
		int num1 = deque.poll();  	 // 0, deque = [1, 2, 3];
		int num2 = deque.peek();  	 // 1
		int num3 = deque.pollLast(); // 3, deque = [1, 2]
		int num4 = deque.peekLast(); // 2

		System.out.println(num4);
	}

	public void HashMapMethods() {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 1); map.put('b', 2); map.put('c', 3); map.put('d', 4);
		map.get('c');
		if(map.containsKey('c')) {}
		if(map.containsValue(1)) {}
		for(Character k : map.keySet()) {}
		for(Integer v : map.values()) {}

		Collection<Integer> count = map.values();
		int maxCnt = Collections.max(count);
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			if(entry.getValue() == maxCnt){
				//System.out.println(entry.getKey()); //d
			}
		}

		if (!map.isEmpty());
		int size = map.size();
	}

	public void HashSetMethods() {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		while(set.add(0)){
			//System.out.println("add 0"); // Just print once
		}
		set.remove(0);
		if(set.contains(0)) {}
		boolean flag = set.isEmpty();
		int size = set.size();
	}



	public static void main(String[] args){
		JavaMethodsSummary x = new JavaMethodsSummary();
		x.StringMethods();
		x.StringBuilderMethods();
		x.ArrayMethods();
		x.ListMethods();
		x.StackMethods();
		x.QueueMethods();
		x.DequeMethods();
		x.HashMapMethods();
		x.HashSetMethods();
	}
}