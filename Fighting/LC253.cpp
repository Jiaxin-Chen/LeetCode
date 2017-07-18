/*
253. Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

struct Interval{
	int start;
	int end;
	Interval(): start(0), end(0) {}
	Interval(int s, int e): start(s), end(e) {}
};

class LC253{
public:
	// Time Complexity: O(NlogN)
	// Runtime: 16ms, beats 26.89%
	int minMeetingRooms(vector<Interval>& intervals){
		if(intervals.size() == 0)
			return 0;
		vector<int> starts, ends;
		int n = intervals.size();

		for(int i = 0; i < n; i++){
			starts.push_back(intervals[i].start);
			ends.push_back(intervals[i].end);
		}

		//sort(begin(starts), end(starts));
		sort(starts.begin(), starts.begin() + n);
		sort(begin(ends), end(ends));
		
		int count = 0, endIdx = 0, emptyRoomNum = 0;
		for(int i = 0; i < n; i++){
			while(starts[i] >= ends[endIdx]){
				++endIdx;
				++emptyRoomNum;	
			}
			emptyRoomNum ? --emptyRoomNum : ++count;
		}
		return count;
	}
};

int main(){
	vector<Interval> intervals;
	intervals.push_back(Interval(9, 10));
	intervals.push_back(Interval(4, 9));
	intervals.push_back(Interval(4, 17));
	LC253 x;
	cout << x.minMeetingRooms(intervals) << endl;

	return 0;
}