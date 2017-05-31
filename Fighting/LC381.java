/*
381. Insert Delete GetRandom O(1) - Duplicates allowed

Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. 
The probability of each element being returned is linearly related to the number of same value the collection contains.

Example:
// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();
// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);
// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);
// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);
// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();
// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);
// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
 */

import java.util.*;

// Time Complexity: O(1)
// Runtime: 120ms, beats 99.13%
public class LC381{

	List<Integer> nums = new ArrayList<Integer>();
	Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

	/** Initialize your data structure here. */
    public LC381() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean flag = map.containsKey(val);
    	if(!flag){
    		map.put(val, new HashSet<Integer>());
    	}
    	map.get(val).add(nums.size());
    	nums.add(val);

    	return !flag;
        
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean flag = map.containsKey(val);
        if(flag){
        	int removeIdx = map.get(val).iterator().next();
        	int last = nums.get(nums.size() - 1);
        	map.get(val).remove(removeIdx);
        	if(removeIdx < nums.size() - 1){
        		nums.set(removeIdx, last);		
        		map.get(last).remove(nums.size() - 1);
        		map.get(last).add(removeIdx);
        	}
        	nums.remove(nums.size() - 1);
        	if(map.get(val).isEmpty())
        		map.remove(val);

        	return true;
        }

        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = (int)(Math.random() * nums.size());
        return nums.get(index);
    }

    public static void main(String[] args){
    	LC381 x = new LC381();
    	System.out.println(x.insert(4));
    	System.out.println(x.insert(3));
    	System.out.println(x.insert(4));
    	System.out.println(x.insert(2));
    	System.out.println(x.insert(4));
    	System.out.println(x.getRandom());
    	System.out.println(x.remove(4));
    	System.out.println(x.remove(3));
    	System.out.println(x.remove(4));
    	System.out.println(x.remove(4));
    }
}