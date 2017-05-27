/*
57. Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

import java.util.*;
import java.util.Collection;

class Interval{
	int start; 
	int end; 

	Interval(){
		start = 0;
		end = 0;
	}

	Interval(int s, int e){
		start = s;
		end = e;
	}
}

public class LC057{
	// Time Complexity: O(N)
	// Runtime: 14ms, beats 90.55%
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> res = new ArrayList<Interval>();

		// Add the first part without newInterval to res
		int i = 0;
		while(i < intervals.size() && intervals.get(i).end < newInterval.start){
			res.add(intervals.get(i++));
		}

		// Merge intervals with newInterval
		while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
			newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i++).end, newInterval.end));
		}
		res.add(newInterval);

		// Add the left of intervals to res
		while(i < intervals.size()){
			res.add(intervals.get(i++));
		}
		return res;
	}

	public static void main(String[] args){
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		Interval newInterval = new Interval(4, 9);

		LC057 x = new LC057();
		List<Interval> res = x.insert(intervals, newInterval);
		for(int i = 0; i < res.size(); i++){
			System.out.println("[" + res.get(i).start + ", " + res.get(i).end + "]");
		}
	}
}