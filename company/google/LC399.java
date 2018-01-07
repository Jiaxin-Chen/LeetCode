/*
399. Evaluate Division

Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
*/

import java.util.*;

class LC399{
	// Time Complexity: O(MN)
	// Runtime: 4ms, beats 22.33%
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		double[] res = new double[queries.length];
		Map<String, List<String>> pairs = new HashMap<>();
		Map<String, List<Double>> valuePairs = new HashMap<>();
		

		// Step 1: construct the graph, including the inverse value 1/k
		for(int i = 0; i < equations.length; i++){
			String[] equation = equations[i];
			if(!pairs.containsKey(equation[0])){
				pairs.put(equation[0], new LinkedList<>());
				valuePairs.put(equation[0], new LinkedList<>());
			}
			if(!pairs.containsKey(equation[1])){
				pairs.put(equation[1], new LinkedList<>());
				valuePairs.put(equation[1], new LinkedList<>());
			}
			pairs.get(equation[0]).add(equation[1]);
			valuePairs.get(equation[0]).add(values[i]);
			// inverse map, value = 1/k
			pairs.get(equation[1]).add(equation[0]);
			valuePairs.get(equation[1]).add(1 / values[i]);
		}

		// Step 2: traverse the queries, create the new hashset for each query
		for(int i = 0; i < queries.length; i++){
			res[i] = dfs(pairs, valuePairs, queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
			if(res[i] == 0.0){
				res[i] = -1.0;
			}
		}

		return res;
	}

	private double dfs(Map<String, List<String>> pairs, Map<String, List<Double>> valuePairs, String start, String end, HashSet<String> set, double value){
		// indicates the query string doesn't exist at all
		if(!pairs.containsKey(start) || !pairs.containsKey(end)){
			return 0.0;
		}
		// indicates their is a cycle
		if(set.contains(start)){
			return 0.0;
		}
		// indicates we found the value in the valueList
		if(start.equals(end)){
			return value;
		}
		
		List<String> strList = pairs.get(start);
		List<Double> valuesList = valuePairs.get(start);
		double res = 0.0;
		set.add(start);
		for(int i = 0; i < strList.size(); i++){
			// for the case a/c = a/b * b/c, so we need multiply the values
			res = dfs(pairs, valuePairs, strList.get(i), end, set, value * valuesList.get(i));
			if(res != 0.0){
				break;
			}
		}
		return res;
	}

	public static void main(String[] args){
		String[][] equations = new String[][]{{"a", "b"}, {"b", "c"}};
		double[] values = new double[]{2.0, 3.0};
		String[][] queries = new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

		LC399 x = new LC399();
		double[] res = x.calcEquation(equations, values, queries);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
	}
}