/*
284. Peeking Iterator

Given an Iterator class interface with methods: next() and hasNext(), 
design and implement a PeekingIterator that support the peek() operation -- 
it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

Follow up: How would you extend your design to be generic and work with all types, not just integer?
*/

import java.util.*;

// Time Complexity: O(1)
// Runtime: 131ms, beats 1.49%
class PeekingIterator implements Iterator<Integer> {
	Integer next = null;
	Iterator<Integer> iter;

	public PeekingIterator(Iterator<Integer> iterator){
		iter = iterator;
		if(iterator.hasNext()){
			next = iter.next();
		}
	}

	// Returns the next element in the iteration without advancing the iterator. 
	public Integer peek(){
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
	@Override
	public Integer next(){
		Integer res = next;
		next = iter.hasNext() ? iter.next() : null;
		return res;
	}

	@Override
	public boolean hasNext(){
		return next != null;
	}
}


// Optimization: consider null values
class PeekingIterator implements Iterator<Integer> {

	Integer next;
	Iterator<Integer> iter;
	boolean noSuchElement;

	public PeekingIterator(Iterator<Integer> iterator){
		iter = iterator;
		advanceIter();
	}

	public Integer peek(){
		return next;
	}

	@Override
	public Integer next(){
		if(noSuchElement){
			throw new NoSuchElementException();
		}
		Integer res = next;
		advanceIter();
		return res;
	}

	@Override
	public boolean hasNext(){
		return !noSuchElement;
	}

	private void advanceIter(){
		if(iter.hasNext()){
			next = iter.next();
		}else{
			noSuchElement = true;
		}
	}
}