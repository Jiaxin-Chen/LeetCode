/*
266. Palindrome Permutation

Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 */

#include<iostream>

using namespace std;

class LC266{
public:
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 0ms, beats 37.79%
	bool canPermutePalindrome(string s){
		int n = s.length();
		if(n == 0)
			return false;

		int map[128] = {0};
		int count = 0;

		for(int i = 0; i < n; i++){
			map[s[i]]++;
		}
		for(int key = 0; key < 128 && count <= 1; key++){
			count += map[key] % 2;
		}

		return count <= 1;
	}
};

int main(){
	LC266 x;
	string s = "aab";
	cout <<  x.canPermutePalindrome(s) << endl;
	return 0;
}