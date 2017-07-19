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
	bool canPermutePalindrome(string s){
		int n = s.length();
		if(n == 0)
			return false;

		for(int i = 0, j = n - 1; i <= j; i++, j--){
			if(s[i] != s[j])
				return false;
		}
		return true;
	}
};

int main(){
	LC266 x;
	string s = "carerac";
	cout <<  x.canPermutePalindrome(s) << endl;
	return 0;
}