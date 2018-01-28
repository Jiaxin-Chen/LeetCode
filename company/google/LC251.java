/*
251. Flatten 2D Vector

Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
*/

import java.util.*;


public class Vector2D implements Iterator<Integer> {

	private Iterator<List<Integer>> input;
	private Iterator<Integer> cur;

    public Vector2D(List<List<Integer>> vec2d) {
        input = vec2d.iterator();
        cur == null;
    }

    @Override
    public Integer next() {
        hasNext();
        return cur.next();
    }

    @Override
    public boolean hasNext() {
    	// we need use while loop not if condition here, corner case: [[], [1], []]
        while((cur == null || !cur.hasNext()) && input.hasNext()){
        	cur = input.next().iterator();
        }
        return cur != null && cur.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */