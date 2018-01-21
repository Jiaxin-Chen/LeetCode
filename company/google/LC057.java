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

class LC057{
	// Time Complexity: O(NlogN)
	// Because the intervals acutally sorted, it's not necessary for us to sort the intervals again
	// Runtime: 95ms, beats 2.03%
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null){
        	return intervals;
        }
        List<Interval> res = new LinkedList<>();
        intervals.add(newInterval);
        intervals.sort((i1, i2) -> (i1.start - i2.start));

       	Interval last = intervals.get(0);
       	for(Interval interval : intervals){
       		if(last.end >= interval.start){
       			last.end = Math.max(last.end, interval.end);
       		}else{
       			res.add(last);
       			last = interval;
       		}
       	}
       	res.add(last);
       	return res;
    }

    //------------------------------------------------------------------------------
    // Optimization: 
    // Time Complexity: O(N)
    // Runtime: 14ms, beats 75.31ms
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null){
        	return intervals;
        }
        List<Interval> res = new LinkedList<>();

        int i = 0, n = intervals.size();

        while(i < n && intervals.get(i).end < newInterval.start){
        	res.add(intervals.get(i++));
        }

        while(i < n && intervals.get(i).start <= newInterval.end){
        	newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        	newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        	i++;
        }
        res.add(newInterval);

        while(i < n){
        	res.add(intervals.get(i++));
        }

        return res;
    }

}