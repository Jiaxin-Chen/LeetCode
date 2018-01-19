/*
56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
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

class LC056{
	// Time Complexity: O(nlogn)
	public List<Interval> merge(List<Interval> intervals){		
		if(intervals == null || intervals.size() <= 1){
			return intervals;
		}

		List<Interval> res = new LinkedList<>();

		// Lambda comparison
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

		// Collections comparison
		/*
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){		
				return i1.start - i2.start;
			}
		});*/

		Interval last = intervals.get(0);
		for(Interval interval : intervals){
			if(interval.start <= last.end){
				last.end = Math.max(last.end, interval.end);
			}else{
				res.add(last);
				last = interval;
			}
		}
		res.add(last);

		return res;
	}
}