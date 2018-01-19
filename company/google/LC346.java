/*
346. Moving Average from Data Stream

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

import java.util.*;

class MovingAverage{

	// Time Complexity: O(N)
	// Runtime: 240ms, beats 0.87%
	private Queue<Integer> queue;
	private int winSize;

	public MovingAverage(int size){
		queue = new LinkedList<>();
		winSize = size;
	}

	public double next(int val){
		queue.offer(val);
		if(queue.size() > winSize){
			queue.poll();
		} 

		int count = queue.size();
		long sum = 0; // we need use the long data type here!
		while(count-- > 0){
			int cur = queue.poll();
			sum += cur;
			queue.offer(cur);
		}

		return (double)sum / queue.size();
	}


	//-----------------------------------------------------------

	// Optimization: 
	// Time Complexity: O(1)
	// Runtime: 150ms, beats 47.47%	
	private Queue<Integer> queue;
	private double sum;
	private int winSize;

	public MovingAverage(int size){
		queue = new LinkedList<>();
		winSize = size;
		sum = 0;
	}

	public double next(int val){
		if(queue.size() == winSize){
			sum -= queue.poll();
		}
		queue.offer(val);
		sum += val;
		return sum / queue.size();
	}
}