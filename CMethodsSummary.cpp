#include<iostream> 	 	// std::cout
#include<vector>    	// vector
#include<algorithm> 	// sort, reverse
#include<stack>     	// stack
#include<deque>     	// deque
#include<climits>   	// INT_MIN, INT_MAX
#include<stdlib.h>  	// atoi, abs
#include<math.h>    	// fabs, labs
#include<string>    	// string
#include<unordered_map> // unordered_map
#include<utility> 		// pair

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
		sort(starts.begin(), starts.end());  //void
		// custom sort, sort intervals.start in the descending order
		sort(intervals.begin(), intervals.end(), compare_start);  // void
		// custom sort, sort intervals.end in the ascending order
		sort(intervals.begin(), intervals.end(), compare_end);    // void

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


	void reverseMethods(){
		string s = "abcdef";
		reverse(s.begin(), s.end());   // void
		vector<int> nums = {1, 2, 3, 4, 5, 6};
		reverse(nums.begin(), nums.end());
		cout << s << endl;
		for(int i = 0; i < nums.size(); i++) cout << nums[i] << " ";
	}


	void stackMethods(){
		stack<int> s;
		for(int i = 1; i <= 6; i++) s.push(i);  // void
		int top = s.top();   	// 6
		int size = s.size();    // 6
		bool flag = s.empty();  // false
		
		for(int i = 1; i <= 6; i++) s.pop();    // void
		//top = s.top();   	// Segmentation fault
		size = s.size();    // 0
		flag = s.empty();   // true
	}



	void vectorMethods(){
		vector<int> nums;
		for(int i = 1; i <= 6; i++) nums.push_back(i); // void
		vector<int> nums2(3, 6);   //{6, 6, 6}
		vector<int> nums3(nums2.begin(), nums2.begin() + 2); // {6, 6}
		vector<int> nums4(nums3);  // {6, 6}

		int size = nums.size();    // 6
		bool flag = nums.empty();  // false
		int front = nums.front();  // 1
		int back = nums.back();    // 6

		// void resize (size_type n);
		nums.resize(3);     // {1, 2, 3}
		// void resize (size_type n, const value_type& val);
		nums.resize(6, 5);  // {1, 2, 3, 5, 5, 5}
		// If not specified, the default constructor is used instead.
		nums.resize(8);     // {1, 2, 3, 5, 5, 5, 0, 0}

		for(int i = 1; i <= 4; i++) nums.pop_back();  // void, {1, 2, 3, 5}

		vector<int>::iterator it;
		it = nums.begin();   
		// Single element: iterator insert(iterator position, const value_type& val);
		it = nums.insert(it, 0);  // {0, 1, 2, 3, 5}
		// Fill: void insert(iterator position, size_type n, const value_type& val);
		nums.insert(it + 4, 1, 4);   // {0, 1, 2, 3, 4, 5}
		// Range: void insert (iterator position, InputIterator first, InputIterator last);
		nums.insert(it + 3, nums4.begin(), nums4.end());  // {0, 1, 2, 6, 6, 3, 4, 5}

		// iterator erase (const_iterator position);
		nums.erase(nums.begin() + 3);  // {0, 1, 2, 6, 3, 4, 5}
		// iterator erase (const_iterator first, const_iterator last);
		nums.erase(nums.begin() + 4, nums.end());  // {0, 1, 2, 6}

		// void swap (vector& x);
		nums2.swap(nums3); // nums2 = {6, 6}, nums3 = {6, 6, 6}
		// void clear() noexcept;
		nums4.clear();     // nums4 = {}

		for(it = nums4.begin(); it < nums4.end(); it++)
			cout << *it << endl; // Accessing it by iterator pointer
	}


	void unordered_mapMethods(){
		unordered_map<char, int> map = {{'a', 1}, {'b', 2}};
		unordered_map<char, int> tmp1 = {{'c', 3}, {'d', 4}};
		pair<char, int> pair1 ('m', 0);

		// void
		map.insert(pair1);						 // copy insertion
		map.insert(make_pair<char,int>('e', 5)); // move insertion
		map.insert(tmp1.begin(), tmp1.end());    // range insertion
		map.insert({{'x', 11}, {'y', 22}});      // Initial list insertion
		map['d']++;    // add {'d', 1}
		map['e']++;    // increase {'e', 5}
		map['f'] = 10; // add {'f', 10}

		char ch = 'a';
		unordered_map<char, int>::iterator it = map.find(ch);
		cout << it->first << " " << it->second << endl;

		// Searches the container for elements whose key is k and returns the number of elements found. 
		// Because unordered_map containers do not allow for duplicate keys, this means that the function actually returns 1 if an element with that key exists in the container, and zero otherwise.
		int val =  map.count('e'); // 1

		// {{'f', 10}, {'y', 22}, {'c', 3}, {'d', 5}, {'e', 6}, {'x', 11}, {'m', 0}, {'b', 2}, {'a', 1}}
		cout << endl << "map contains: " << endl;
		for(auto& x : map)
			cout << x.first << ": " << x.second << endl;

		// void
		map.erase(map.begin());   // erase by iterator, delete {'f', 10}
		map.erase(map.find('x')); // erase by iterator, delete {'f', 10}
		map.erase('d');           // erase by key, delete {'d', 5}
		map.erase(map.find('m'), map.end());  // erase by range, delete {{'m', 0}, {'b', 2}, {'a', 1}}
		
		// {{'y', 22}, {'c', 3}, {'e', 6}}
		cout << endl << "iterator traverse: " << endl;
		for(auto iter = map.begin(); iter != map.end(); iter++)
			cout << iter->first << ": " << iter -> second << endl;

	}


	void pairMethods(){
		pair<int, char> foo;
		pair<int, int> bar;
		pair<string, double> tmp ("aaa", 1.1);

		foo = make_pair(10, 'A');
		bar = make_pair(20.5, 'A'); // implicit conversion from pair<double,char>

		cout << "foo: " << foo.first << ", " << foo.second << endl;
		cout << "bar: " << bar.first << ", " << bar.second << endl;
	}


	void arrayMethods(){
		int nums1[5];  // random num, it's better to initialize
		int nums2[5] = {1, 2}; // {1, 2, 0, 0, 10
		int nums3[5] = {1, 2, 3, 4, 5};
		char ch[5] = {'1', '2', '3', '4', '\0'};
		char ch2[] = "abcdefg";

		int *pointer;  // int *pointer = nums3;
		pointer = nums3;
		
		for(int i = 0; i < 5; i++){
			cout << *(nums3 + i) << endl;
			cout << *(pointer + i) << endl;
		}
		cout << ch << endl << ch2 << endl;
	}


	void conversionMethods(){
		int x = 123;
		string str1 = to_string(x);
		string str2 = "456";
		int y = stoi(str2);
		char ch1[6] = "12345";  
		int z = atoi(ch1);
		cout << str1 << endl << y << endl << z << endl;
	}

};

int main(){
	CMethodSummary x;
	//x.sortMethods();
	//x.reverseMethods();
	x.unordered_mapMethods();
	//x.pairMethods();
	//x.stackMethods();
	x.vectorMethods();
	//x.arrayMethods();
	//x.conversionMethods();

	return 0;
}