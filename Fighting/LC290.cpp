/*
290. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

#include<iostream>
#include<sstream>  // istringstream
#include<unordered_map>

using namespace std;

class LC290{
public:
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 2.41%
	bool wordPattern(string pattern, string str){
		unordered_map<char, int> p2i;
		unordered_map<string, int> s2i;

		istringstream in(str);
		int i = 0, n = pattern.length();

		for(string word; in >> word; ++i){
			if(i == n || p2i[pattern[i]] != s2i[word])
				return false;
			p2i[pattern[i]] = s2i[word] = i + 1;
		}
		return i == n;
	}
};

int main(){
	LC290 x;
	string pattern = "abaa";
	string str = "dog cat cat dog";
	cout << x.wordPattern(pattern, str) << endl;
	return 0;
}