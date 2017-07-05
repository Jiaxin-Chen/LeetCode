/*
170. Two Sum III - Data structure design

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 */

import java.util.*;

public class LC170{
	// Time Complexity: O(N)
	// Runtime: 312ms, beats 65.60%
	List<Integer> list;
	Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public LC170() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
    	if(map.containsKey(number))
    		map.put(number, map.get(number) + 1);
    	else{
    		map.put(number, 1);
    		list.add(number);
    	}
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
 		for(int i = 0; i < list.size(); i++){
 			int num1 = list.get(i);
 			int num2 = value - num1;
 			if((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2)))
 				return true;
 		}
 		return false;
    }


    // Time Limit Exceed....
    /** Add the number to an internal data structure.. */
    public void add2(int number) {
    	int sum = 0;
        for(int i = 0; i < list.size(); i++){
        	sum = list.get(i) + number;
        	if(!map.containsKey(sum))
        		map.put(sum, 1);
        }
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find2(int value) {
        if(map.containsKey(value))
        	return true;
        return false;
    }


    public static void main(String[] args){
    	LC170 x = new LC170();
    	x.add(1);
    	x.add(3);
    	x.add(5);
    	System.out.println(x.find(4));
    	System.out.println(x.find(7));
    }
}