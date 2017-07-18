/*
252. Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
 */

#include<iostream>   // cout
#include<vector>	 // vector
#include<algorithm>  // sort
using namespace std;

struct Interval {
	int start;
	int end;
	Interval() : start(0), end(0) {}
	Interval(int s, int e) : start(s), end(e) {}
};

class LC252{
public:
	bool canAttendMeetings(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), compare);

        int n = intervals.size();
        for(int i = 0; i < n - 1; i++){
       		if(intervals[i].end > intervals[i+1].start)
       			return false;
        }
        return true;
    }

private:
	static bool compare(Interval& interval1, Interval& interval2){
		return interval1.start < interval2.start;
	}
};

int main(){
	vector<Interval> intervals;
	intervals.push_back(Interval(0, 30));
	intervals.push_back(Interval(5, 10));
	intervals.push_back(Interval(15, 20));
	LC252 x;
	cout << x.canAttendMeetings(intervals) << endl;

	return 0;
}