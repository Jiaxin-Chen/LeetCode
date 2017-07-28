/*
291. Word Pattern II

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-emapty substring in str.

Examaples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.
*/

#include<iostream>
#include<unordered_map>
#include<unordered_set>

using namespace std;


// Time Complexity: O(NlogN)
// Runtime: 119ms, beats 47.32%
class LC291{
public:
  bool wordPatternMatch(string pattern, string str) {
        unordered_set<string> st;
        unordered_map<char, string> map;
        return match(str, 0, pattern, 0, st, map);
    }
private:
    bool match(string& str, int i, string& pat, int j, unordered_set<string>& st, unordered_map<char, string>& map) {
        
    	// base case
        int m = str.length(), n = pat.length();
        if (i == m && j == n) return true;
        if (i == m || j == n) return false;

        // get current pattern character
        char c = pat[j];

        // if the pattern character exists
        if (map.find(c) != map.end()) {
            string s = map[c];
            int l = s.length();

            // then check if we can use it to match str[i...i+s.length()]
            if (s != str.substr(i, l)) 
            	return false;

            // if it can match, great, continue to match the rest
            return match(str, i + l, pat, j + 1, st, map);
        } 

        // pattern character does not exist in the map
        for (int k = i; k < m; k++) {
            string s = str.substr(i, k - i + 1);
            if (st.find(s) != st.end()) 
            	continue;

            // create or update
            st.insert(s);
            map[c] = s;

            // continue to match the rest
            if (match(str, k + 1, pat, j + 1, st, map)) 
            	return true;

            // backtracking
            st.erase(s);
            map.erase(c);
        }
        return false;
    }
};

int main(){
	LC291 x;
	string pattern = "abab", str = "redblueredblue";
	cout << x.wordPatternMatch(pattern, str) << endl;
	return 0;
}
