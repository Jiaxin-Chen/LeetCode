/*
380. Insert Delete GetRandom O(1)

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

Example:
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();
// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);
// Returns false as 2 does not exist in the set.
randomSet.remove(2);
// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);
// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();
// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);
// 2 was already in the set, so return false.
randomSet.insert(2);
// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */

import java.util.*;


// Time Complexity: O(1)
// Runtime: 150ms, beats 40.08%
public class LC380{
	List<Integer> nums = new ArrayList<Integer>();
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	/** Initialize your data structure here. */
    public LC380() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
        	return false;
        }

        nums.add(val);
        map.put(val, nums.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
        	return false;
        }

        int last = nums.get(nums.size() - 1);
        int removeIdx = map.get(val);
        nums.set(removeIdx, last);
        nums.remove(nums.size() - 1); // Always remove the last number, which takse O(1)
        //map.remove(val);
        map.put(last, removeIdx);
        map.remove(val); // Must operate map.put first!!!! Otherwise it will cause index bound problem

        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int)(Math.random() * nums.size());
        return nums.get(index);
    }

	public static void main(String[] args){

 		LC380 obj = new LC380();
		boolean param_1 = obj.insert(1);
		System.out.println(param_1);
		boolean param_2 = obj.remove(2);
		System.out.println(param_2);
		param_1 = obj.insert(3);
		System.out.println(param_1);
		param_1 = obj.insert(5);
		System.out.println(param_1);
		int param_3 = obj.getRandom();
		System.out.println(param_3);
	}
}