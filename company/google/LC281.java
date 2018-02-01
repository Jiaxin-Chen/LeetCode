/*
281. Zigzag Iterator

Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. 
If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". 

For example, given the following input:
[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
*/

public class ZigzagIterator {

	// OMG: My right version!!! Although native but it's the FIRST time to design correctly OMG!!!
	// Runtime: 4ms, beats 61.29%
    private Iterator<Integer> iter1;
    private Iterator<Integer> iter2;
    private boolean isIter1;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        /*
        iter1 = v1 != null ? v1.iterator() : null;
        iter2 = v2 != null ? v2.iterator() : null;
        //isIter1 = v1 != null ? true : false;
        */
        iter1 = v1.iterator();
        iter2 = v2.iterator();   
        isIter1 = true;
    }

    public int next() {
        int res = 0;
        // we need check if iter1.hasNext() for the first time, to avoid corner case like [[], [1]]
        if(isIter1 && iter1.hasNext()){
            res = iter1.next();
            if(iter2.hasNext()){
                isIter1 = false;
            }
        // we don't have to check if iter2.hasNext(), because it always run hasNext() first, 
        // if iter2 = null from the begining, the while(hasNext()) will terminate once the iter1 over
        }else{
            res = iter2.next();
            if(iter1.hasNext()){
                isIter1 = true;
            }
        }
        return res;
    }

    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext();
    }


    //-----------------------------------------------------------------------------
    // Optimization: Use Queue to store the Iterator, easily to summarize to k Lists
    // Runtime: 6ms, beats 9.70%
    private Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2){
    	queue = new LinkedList<>();

    	// we cannot use the v1 != null as the condition, because v1 == null means no collection exists at all
    	if(!v1.isEmpty()){
    		queue.offer(v1.iterator());
    	}
    	if(!v2.isEmpty()){
    		queue.offer(v2.iterator());
    	}
    	/*
    	Fault version: cannot check v1 = [] by v1 != null, 
    	because [] is a existed collection but v1.size() = 0 and v1.isEmpty() = true.
    	if(v1 != null){
    		queue.offer(v1.iterator());
    	}
    	if(v2 != null){
    		queue.offer(v2.iterator());
    	}
		*/
    }

    public int next(){
    	Iterator cur = queue.poll();
    	int res = cur.next();
    	if(cur.hasNext()){
    		queue.offer(cur);
    	}
    	return res;
    }

    public boolean hasNext(){
    	return !queue.isEmpty();
    }

    //----------------------------------------------------------------------------
    // Follow up: Use Queue to store the Iterator, easily to summarize to k Lists
    private Queue<Iterator> queue;

    public ZigzagIterator(List<List<Integer>> v){
    	queue = new LinkedList<>();

    	for(int i = 0; i < v.size(); i++){
    		if(!v.get(i).isEmpty()){
    			queue.offer(v.get(i).iterator());
    		}
    	}
    }

    public int next(){
    	Iterator cur = queue.poll();
    	int res = cur.next();
    	if(cur.hasNext()){
    		queue.offer(cur);
    	}
    	return res;
    }

    public boolean hasNext(){
    	return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */