/*
56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
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

public class LC056{
	// Time Complexity: O(NlogN)
	// Runtime: 28ms, beats 58.49%
	public List<Interval> merge(List<Interval> intervals){
		if(intervals.size() < 2){
			return intervals;
		}

		// Time Complexity: O(NlogN)
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval l1, Interval l2){
				return Integer.compare(l1.start, l2.start);
			}
		});

		// Time Complexity: O(N)
		List<Interval> res = new ArrayList<Interval>();
		int curStart = intervals.get(0).start, curEnd = intervals.get(0).end;
		for(Interval interval : intervals){
			if(interval.start <= curEnd){
				curEnd = Math.max(interval.end, curEnd);
			}else{
				res.add(new Interval(curStart, curEnd));
				curStart = interval.start;
				curEnd = interval.end;
			}
		}

		res.add(new Interval(curStart, curEnd));
		return res;
	}


	public static void main(String[] args){
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(15, 18));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(9, 12));
		intervals.add(new Interval(19, 20));

		LC056 x = new LC056();
		List<Interval> res = x.merge(intervals);
		for(int i = 0; i < res.size(); i++){
			System.out.println("[" + res.get(i).start + ", " + res.get(i).end + "]");
		}
	}
}