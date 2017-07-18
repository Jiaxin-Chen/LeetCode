
#include<iostream>  // std::cout
#include<vector>    // vector
#include<algorithm> // sort
#include<stack>     // stack
#include<deque>     // deque
#include<climits>   // INT_MIN, INT_MAX

using namespace std;


struct Interval{
	int start;
	int end;
	Interval(): start(0), end(0) {}
	Interval(int s, int e): start(s), end(e) {}
};

class CMethodSummary{
public:

	void sortMethods(){
		vector<Interval> intervals;
		intervals.push_back(Interval(0, 30));
		intervals.push_back(Interval(5, 10));
		intervals.push_back(Interval(15, 20));
		vector<int> starts = {3, 5, 6, 1, 4, 2};

		// Default sort, sort intervals in the ascending order,
		// The range used is [first,last), which contains all the elements between first and last, including the element pointed by first but not the element pointed by last.
		sort(starts.begin(), starts.end());
		// custom sort, sort intervals.start in the descending order
		sort(intervals.begin(), intervals.end(), compare_start);
		// custom sort, sort intervals.end in the ascending order
		sort(intervals.begin(), intervals.end(), compare_end);

		// print
		for(auto start : starts) 
			cout << start << endl;
		for(auto interval : intervals)
			cout << interval.start << ", " << interval.end << endl;
	}
	static bool compare_start(Interval& interval1, Interval& interval2){
		return interval1.start > interval2.start;
	}
	static bool compare_end(Interval& interval1, Interval& interval2){
		return interval1.end < interval2.end;
	}



	void stackMethods(){
		stack<int> s;
		s.push(1);   // void
		int num = s.top();
		int size = s.size();
		bool flag = s.empty();
		s.pop();     // void

		cout << num << " " << size << " " << flag << endl;
	}

};

int main(){
	CMethodSummary x;
	x.sortMethods();
	x.stackMethods();

	return 0;
}