/*
267. Palindrome Permutation II

Given a string s, return all the palindromic permutations (without duplicates) of it. 
Return an empty list if no palindromic permutation could be form.

For example:
Given s = "aabb", return ["abba", "baab"].
Given s = "abc", return [].
*/

#include<iostream>
#include<vector>
#include<unordered_map>
#include<string>
#include<algorithm>

using namespace std;

class LC267{
public:
	vector<string> generatePalindromes(string s){
		
		unordered_map<char, int> map;
		vector<string> res;
		vector<char> list; 
		int n = s.length(), count = 0;
		string str = "";
		string mid = "";

		for(int i = 0; i < n; i++){
			map[s[i]]++;
			count += (map[s[i]] % 2 != 0) ? 1 : -1;
		}
		if(count > 1)
			return res;
/*
		for(auto& x : map){
			char key = x.first;
			int val = x.second;
			cout << key << " " << val << endl;
			if(val & 1)
				mid = key;
			//cout << mid << " ddd" << endl;
			for(int i = 0; i < val / 2; i++)
				list.push_back(key);
			cout << "end" << endl;
		}
*/

		for(int i = 0; i < list.size(); i++)
			cout << list[i] << endl;

		for(auto it = map.begin(); it != map.end(); ++it){
			char key = it->first;
			int val = it->second;

			if(val % 2 != 0)
				mid.push_back(key);


			for(int i = 0; i < val / 2; i++){
				list.push_back(key);
			}
			cout << key << " " << val << endl;
		}

		cout << mid << " " << str << endl;

		vector<bool> used(false, list.size());
		backtracking(res, list, used, mid, str);
		return res;
	}

	void backtracking(vector<string>& res, vector<char>& list, vector<bool>& used, string& mid, string& str){
		if(str.length() == list.size()){
			string tmp = str;
			reverse(str.begin(), str.end());
			res.push_back(tmp + mid + str);
			return;
		}

		for(int i = 0; i < list.size(); i++){
			if(i > 0 && (list[i] == list[i-1]) && !used[i-1])
				continue;
			if(!used[i]){
				used[i] = true;
				str.push_back(list[i]);
				backtracking(res, list, used, mid, str);
				str.erase(str.end());
				used[i] = false;
			}
		}
	}
};

int main(){
	LC267 x;
	string s = "aabbc";
	vector<string> res = x.generatePalindromes(s);
	for(string s : res)
		cout << s << endl;
	return 0;
}
