/*
146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ /*);
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

import java.util.*;

class ListNode{
	int key;
	int value;
	ListNode prev;
	ListNode next;
	ListNode(int key, int value){
		this.key = key;
		this.value = value;
	}
}

// Time Complexity: O(1)
// Runtime: 148ms, beats 81.32%
public class LC146{

	Map<Integer, ListNode> map;
	ListNode head, tail;
	int capacity, count;
	
	public LC146(int capacity){
		map = new HashMap<>();
		head = new ListNode(0, 0);
		tail = new ListNode(0, 0);
		head.prev = null;
		head.next = tail;
		tail.prev = head;
		tail.next = null;
		this.capacity = capacity;
		count = 0;
	}

	public void deleteNode(ListNode node){
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public void insertNode(ListNode node){
		node.next = head.next;
		node.next.prev = node;
		node.prev = head;
		head.next = node;
	}

	public int get(int key){
		if(map.containsKey(key)){
			ListNode node = map.get(key);
			deleteNode(node);
			insertNode(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value){
		if(map.containsKey(key)){
			ListNode node = map.get(key);
			deleteNode(node);
			node.value = value;
			insertNode(node);
		}else{
			ListNode node = new ListNode(key, value);
			map.put(key, node);
			if(count < capacity){
				count++;
				insertNode(node);
			}else{
				map.remove(tail.prev.key);
				deleteNode(tail.prev);
				insertNode(node);
			}
		}
	}
}