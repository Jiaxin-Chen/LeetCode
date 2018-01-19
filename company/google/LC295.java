/*
295. Find Median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
*/

import java.util.*;

class MedianFinder{

	// Time Complexity: O(NlogN)
	// TLE...
	private List<Integer> nums;

	public MedianFinder(){
		nums = new LinkedList<>();
	}

	public void addNum(int num){
		nums.add(num);
		Collections.sort(nums);  // Time Complexity: O(NlogN)
	}

	public double findMedian(){
		double median;
		int mid = nums.size() / 2;
		if(nums.size() % 2 == 0){
			median = (double)(nums.get(mid - 1) + nums.get(mid)) / 2;
		}else{
			median = (double)(nums.get(mid));
		}
		return median;
	}


	//--------------------------------------------------------
	// Optimization:
	// Time Complexity: O(logn)
	// Runtime: 244ms, beats 49.56%
										  // if the sorted array: [1, 2, 4, 5, 6, 7]
	private PriorityQueue<Integer> small; // samll store the num from the max to min in left part of the sorted array: [4, 2, 1]
	private PriorityQueue<Integer> large; // large store the num from the min to max in right part of the sorted array:[5, 6, 7]

	public MedianFinder(){
		small = new PriorityQueue<>((a, b) -> (b-a));
		large = new PriorityQueue<>();
	}

	public void addNum(int num){
		// always make sure the median in the large if the size is odd
		large.offer(num);
		small.offer(large.poll());
		if(large.size() < small.size()){
			large.offer(small.poll());
		}
	}

	public double findMedian(){
		return large.size() > small.size() ? large.peek() : (large.peek() + small.peek()) / 2.0;
		
	}
}