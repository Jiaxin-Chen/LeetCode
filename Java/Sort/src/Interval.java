import java.util.*;

public class Interval {
	/* 56. Merge Intervals:
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * Input: [1,3],[2,6],[8,10],[15,18]
	 * Output: [1,6],[8,10],[15,18]
	 */
	
	int start;
	int end;
	
	public Interval(){
		start = 0;
		end = 0;
	}
	
	public Interval(int s, int e){
		start = s;
		end = e;
	}
	
	public static List<Interval> merge(List<Interval> intervals){
		if(intervals.size() <= 1){
			return intervals;
		}
		
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval l1, Interval l2){
				return Integer.compare(l1.start, l2.start);
			}
		});
		
		List<Interval> res = new LinkedList<Interval>();
		int start = intervals.get(0).start, end = intervals.get(0).end;
		
		for(Interval interval : intervals){
			if(interval.start <= end){
				end = Math.max(interval.end, end);
			}else{
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		res.add(new Interval(start, end));
		return res;
	}
	
	
	/*
	 * 57. Insert Interval:
	 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	 * You may assume that the intervals were initially sorted according to their start times.
	 * 
	 * Input: [1,3],[6,9], merge [2,5], Output: [1,5],[6,9]
	 * Input: [1,2],[3,5],[6,7],[8,10],[12,16], merge [4,9], Output: [1,2],[3,10],[12,16]
	 */
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> res2 = new LinkedList<Interval>();
		if(intervals == null){
			res2.add(newInterval);
			return res2;
		}
		
		if(newInterval == null){
			return intervals;
		}

		for(Interval interval : intervals){
			if(interval.end < newInterval.start){
				res2.add(interval);
			}else if(interval.start > newInterval.end){
				res2.add(newInterval);
				res2.add(interval);
				newInterval = null;
			}else{
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		if(newInterval != null){
			res2.add(newInterval);
		}
		return res2;
		
	}
	
	
	// The fastest version!!!! Genius!!!
	public static List<Interval> insert2(List<Interval> intervals, Interval newInterval){
		/**
		 * Since the original list is sorted and all intervals are disjoint,
		 * apply binary search to find the insertion index for the new
		 * interval. [LC35]
		 * 
		 * 1. Find insIdx=the insertion index of new.start, i.e., the first
		 * index i such that list.get(i).start>=new.start.
		 * 
		 * 2. Find nxtIdx=the insertion index of new.end, i.e., the first
		 * index i such that list.get(i).end>=new.end.
		 * 
		 * 3. Remove all elements of the list with indices insIdx<=i<nxtIdx.
		 * 
		 * 4. Merge new with list.get(insIdx-1) or list.get(nxtIdx) or both.
		 */

		int n = intervals.size();
		if (n == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		int low = 0, high = n - 1, mid = 0;
		int temp, target = newInterval.start;
		while (low <= high) {
			mid = (low + high) / 2;
			temp = intervals.get(mid).start;
			if (temp == target)
				break;
			if (temp < target)
				low = mid + 1;
			else
				high = mid - 1;
		}

		// insIdx = the index where new interval to be inserted
		int insIdx = (low <= high) ? mid : low;
		Interval pre = (insIdx == 0) ? null : intervals.get(insIdx - 1);
		// 0<=insIdx<=n, pre=[insIdx-1], pre.start<new.start

		low = insIdx;
		high = n - 1;
		target = newInterval.end;
		while (low <= high) {
			mid = (low + high) / 2;
			temp = intervals.get(mid).end;
			if (temp == target)
				break;
			if (temp < target)
				low = mid + 1;
			else
				high = mid - 1;
		}

		// nxtIdx= the next index after the inserted new interval
		int nxtIdx = (low <= high) ? mid : low;
		Interval nxt = (nxtIdx == n) ? null : intervals.get(nxtIdx);
		// insIdx<=nxtIdx<=n, nxt=[nxtIdx], nxt.end>=new.end

		// [0]...[insIdx-1] <--> [insIdx]...[nxtIdx-1][nxtIdx]...[n]
		intervals.subList(insIdx, nxtIdx).clear();

		// check whether newInterval can be merged with pre or nxt
		boolean isMerged = false, isMerged2 = false;
		if (insIdx > 0 && pre.end >= newInterval.start) {
			pre.end = Math.max(pre.end, newInterval.end);
			isMerged = true;
		}

		if (nxtIdx < n && newInterval.end >= nxt.start) {
			nxt.start = Math.min(nxt.start, newInterval.start);
			isMerged2 = isMerged;
			isMerged = true;
		}

		if (!isMerged) {
			intervals.add(insIdx, newInterval);
			return intervals;
		}

		// merged with pre or nxt or both, deal with the both case
		if (isMerged2 && pre.end >= nxt.start) {
			nxt.start = pre.start; // pre.start < new.start, nxt.start;
			intervals.remove(insIdx - 1); // remove pre
		}

		return intervals;
	}
	
	
	
	public static void main(String[] args){
		List<Interval> intervals1 = new LinkedList<Interval>();
		int[] start1 = {1, 2, 8, 15};
		int[] end1 = {3, 6, 10, 18};
		
		for(int i = 0; i < start1.length; i++){
			intervals1.add(new Interval(start1[i], end1[i]));
		}		
		List<Interval> res1 = merge(intervals1);
		for(int i = 0; i < res1.size(); i++){
			System.out.println("[" + res1.get(i).start + "," + res1.get(i).end + "]");
		}
		
		System.out.println("---------------------------------------------------------");
		
		List<Interval> intervals2 = new LinkedList<Interval>();
		Interval newInterval = new Interval(4, 9);
		int[] start2 = {1, 3, 6, 8, 12};
		int[] end2 = {2, 5, 7, 10, 16};
		
		for(int i = 0; i < start2.length; i++){
			intervals2.add(new Interval(start2[i], end2[i]));
		}
		List<Interval> res2 = insert(intervals2, newInterval);
		for(int i = 0; i < res2.size(); i++){
			System.out.println("[" + res2.get(i).start + "," + res2.get(i).end + "]");
		}

	}
}
