/*
269. Alien Dictionary

There is a new alien language which uses the latin alphabet. 
However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

Example 1:
Given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,
[
  "z",
  "x"
]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,
[
  "z",
  "x",
  "z"
]
The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

 */

#include<iostream>
#include<vector>
#include<unordered_map>
#include<unordered_set>
#include<algorithm> // reverse

using namespace std;


// Time Complexity: O(NlogN)
// Runtime: 3ms, beats 27.41%
// Cannot understand....
class LC269{
public:
	string alienOrder(vector<string>& words){
		if(words.size() == 1)
			return words.front();

		unordered_map<char, unordered_set<char>> graph;
		for(int i = 1; i < words.size(); i++){
			string t1 = words[i-1];
			string t2 = words[i];

			bool found = false;

			for(int j = 0; j < max(t1.length(), t2.length()); j++){
				if(j < t1.length() && graph.count(t1[j]) == 0)
					graph.insert(make_pair(t1[j], unordered_set<char>()));
				if(j < t2.length() && graph.count(t2[j]) == 0)
					graph.insert(make_pair(t2[j], unordered_set<char>()));
				if(j < t1.length() && j < t2.length() && t1[j] != t2[j] && !found){
					graph[t1[j]].insert(t2[j]);
					found = true;
				}
			}
		}
		return topologicalSort(graph);
	}

	string topologicalSort(unordered_map<char, unordered_set<char>>& graph){
		unordered_set<char> visited;
		unordered_set<char> rec;
		string order;

		for(auto iter = graph.begin(); iter != graph.end(); iter++){
			if(DFS(graph, visited, rec, order, iter->first) == false)
				return "";
		}
		reverse(order.begin(), order.end());
		return order;
	}

	bool DFS(unordered_map<char, unordered_set<char>>& graph, unordered_set<char>& visited, unordered_set<char>& rec, string& order, char n){
		if(rec.count(n))
			return false;
		if(visited.count(n))
			return true;

		visited.insert(n);
		rec.insert(n);

		for (auto iter = graph[n].begin(); iter != graph[n].end(); ++iter)
			if (DFS(graph, visited, rec, order, *iter) == false)
				return false;

		rec.erase(rec.find(n));
		order += string(1, n);

		return true;
	}
};

int main(){
	LC269 x;
	vector<string> words = {"wrt", "wrf", "er", "ett", "rftt"};
	cout << x.alienOrder(words) << endl;
	return 0;
}