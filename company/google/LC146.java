/*
146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );

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

class LRUCache {
    
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int k, int v){
            key = k;
            value = v;
            prev = null;
            next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;  // head.next points to the first node
    private Node tail;  // tail.prev points to the last node

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        // remove current
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        // move current node to the tail
        moveToTail(cur);
        
        return cur.value;
    }
    
    public void put(int key, int value) {
    	// get 这个方法会把key挪到最末端，因此，不需要再调用 move_to_tail
        if(get(key) != -1){
            map.get(key).value = value;
            return;
        }
        
        // we need remove the head.next node because the map is full
        if(map.size() == capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        // insert the current node and move it to the tail
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(Node cur){
        cur.prev = tail.prev;
        tail.prev = cur;
        cur.prev.next = cur;
        cur.next = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */