/*
253. Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
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

class LC253{
	// Time Complexity: O(NlogN)
	// Runtime: 12ms, beats 33.89%
	public int minMeetingRooms(Interval[] intervals){
		if(intervals == null || intervals.length == 0){
			return 0;
		}

		// Step 1: Sort the intervals by start time
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		});


		// Step 2: Use a min heap to track the minimum end time of merged intervals, 
		// because we hope to get the meeting room that finishes earliest
		//PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.length, (i1, i2) -> (i1.end - i2.end));
		PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.length, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.end - i2.end;
			}
		});

		// Step 3: start with the first meeting, put it to a meeting room
		queue.offer(intervals[0]);

		for(int i = 1; i < intervals.length; i++){
			// Step 4: get the meeting room that finishes earliest
			Interval interval = queue.poll();

			// Step 5: if the current meeting starts right after, there's no need for a new room, 
			// we can just append the end and merge the interval
			if(interval.end <= intervals[i].start){
				interval.end = intervals[i].end;

			// Step 6: otherwise, this meeting needs a new room, we need offer into the queue
			}else{
				queue.offer(intervals[i]);
			}

			// Step 7: we also need put the room back to the queue
			queue.offer(interval);
		}
		return queue.size();
	}

	//---------------------------------------------------------------------------------
	// Optimization
	// Time Complexity: O(NlogN)
	// Runtime: 4ms, beats 79.48%
	public int minMeetingRooms2(Interval[] intervals){
		if(intervals == null || intervals.length == 0){
			return 0;
		}

		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		int roomNum = 0, endIdx = 0;

		for(int i = 0; i < intervals.length; i++){
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}

		Arrays.sort(starts);
		Arrays.sort(ends);		

		// 开始遍历，如果当前起始时间小于结束时间指针的时间，则结果自增1，反之结束时间指针自增1，
		// 这样可以找出重叠的时间段，从而安排新的会议室
		for(int i = 0; i < intervals.length; i++){
			if(starts[i] < ends[endIdx]){
				roomNum++;
			}else{
				endIdx++;
			}
		}
		return roomNum;
	}
}