/*
271. Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */

#include<iostream>
#include<vector>

using namespace std;

// Time Complexity: O(N)
// Runtime: 49ms, beats 72.77%
class LC271{
public:
	 // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        string res = "";
        for(string s : strs)
        	res += to_string(s.length()) + "/" + s;
        return res;

    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        vector<string> strs;
        int idx = 0, n = s.length();

        while(idx < n){
        	int pos = s.find_first_of('/', idx);   // Find '/' position idx
        	int len = stoi(s.substr(idx, pos - idx));  // find string length
        	idx = pos + 1;   // go to the string idx
        	strs.push_back(s.substr(idx, len));  // get the string
        	idx += len;  // go to the next length of the string
        }
        return strs;
    }
};

int main(){
	LC271 x;
	vector<string> strs = {"111", "add", "*&8"};
	vector<string> res = x.decode(x.encode(strs));
	for(int i = 0; i < res.size(); i++)
		cout << res[i] << endl;
	return 0;
}