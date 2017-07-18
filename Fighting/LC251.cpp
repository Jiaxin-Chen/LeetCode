/*
251. Flatten 2D Vector

Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */

#include<iostream>
#include<vector>

using namespace std;

class LC251{
	vector<vector<int> > data;
	vector<vector<int> >::iterator i, iEnd;
	int j = 0;
	int row, col;

public:
	// Vector position version:
	// Time Complexity: O(N)
	// Runtime: 16ms, beats 20.38%
	LC251(vector<vector<int> >& vec2d){
		data = vec2d;
		row = 0; 
		col = 0;
	}

	int next(){
		return data[row][col++];
	}

	bool hasNext(){
		while(row < data.size() && data[row].size() == col){
			row++;
			col = 0;
		}
		return row != data.size();
	}


	// Iterator version:
	// Time Complexity: O(N)
	// Runtime: 26ms, beats 1.88%
	LC251_2(vector<vector<int> >& vec2d){
		i = vec2d.begin();
		iEnd = vec2d.end();
	}

	int next2(){
		hasNext();
		return (*i)[j++];
	}

	bool hasNext2(){
		while(i != iEnd && j == (*i).size()){
			i++;
			j = 0;
		}
		return i != iEnd;
	}
};

int main(){
	static const int arr1[] = {1, 2};
	static const int arr2[] = {3};
	static const int arr3[] = {4, 5, 6};
	vector<int> vec1(arr1, arr1 + sizeof(arr1) / sizeof(arr1[0]));
	vector<int> vec2(arr2, arr2 + sizeof(arr2) / sizeof(arr2[0]));
	vector<int> vec3(arr3, arr3 + sizeof(arr3) / sizeof(arr3[0]));
	vector<vector<int> > vec2d;
	vec2d.push_back(vec1);
	vec2d.push_back(vec2);
	vec2d.push_back(vec3);
	LC251 x(vec2d);
	while(x.hasNext())
		cout << x.next() << endl;

	return 0;
}