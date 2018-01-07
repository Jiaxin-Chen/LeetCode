/*
332. Reconstruct Itinerary

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/

import java.util.*;

class LC332{
	// DFS + PriorityQueue
	// Time Complexity: O(NlogN)
	// Runtime: 12ms, beats 50.31%
	public List<String> findItinerary(String[][] tickets){
		// because we need the smallest lexical order comes first, so it's better to use PriorityQueue
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		List<String> res = new LinkedList<>();

		// Step 1: construct the graph
		for(String[] ticket : tickets){
			if(!map.containsKey(ticket[0])){
				map.put(ticket[0], new PriorityQueue<>());
			}
			map.get(ticket[0]).offer(ticket[1]); // Time Complexity: O(logN)
		}

		// Step 2: dfs traverse from the JFK(the root)
		dfs(map, res, "JFK");

		return res;
	}

	private void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String departure){
		PriorityQueue<String> arrivals = map.get(departure);
		
		// Step 3: the while condition is no pending arrivals in the arrivals at all, 
		// so we find the final arrival, add into the last of the res
		while(arrivals != null && !arrivals.isEmpty()){
			dfs(map, res, arrivals.poll()); // Time Complexity: O(logN)
		}
		res.add(0, departure);
	}

	//-----------------------------------------------------------------------------------------------------
	// Time Complexity: O(NlogN)
	public List<String> findItinerary2(String[][] tickets){
		Map<String, List<String>> map = new HashMap<>();
		List<String> res = new LinkedList<>();

		// Step 1: build the adjacency matrix for the directed graph
		for(String[] ticket : tickets){
			if(!map.containsKey(ticket[0])){
				map.put(ticket[0], new LinkedList<>());
			}
			List<String> arrivals = map.get(ticket[0]);
			arrivals.add(ticket[1]);
			map.put(ticket[0], arrivals);
		}

		// Step 2: Sort the value for each key so that the string list in lexical order
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			Collections.sort(entry.getValue());
			//System.out.println("key = " + entry.getKey() + ", values = " + entry.getValue());
		}
		test(map);
/*
		// Step 3: dfs
		res.add("JFK");
		dfs2(map, res, "JFK", tickets.length);*/
		return res;
	}

	private int ticketsNumUsed = 0;

	private void dfs2(Map<String, List<String>> map, List<String> res, String departure, int ticketsNum){
		// avoid the final end airport appear
		if(!map.containsKey(departure)){
			return;
		}

		// traverse each arrivals
		List<String> arrivals = map.get(departure);
		//System.out.println("departure = " + departure + ", arrivals = " +  arrivals);
		for(int i = 0; i < arrivals.size(); i++){

			// Step 4: add arrival into res
			String arrival = arrivals.get(i);
			res.add(arrival);
			arrivals.remove(i);
			ticketsNumUsed++;
			// System.out.println("i = " + i + ", arrival = " + arrival);

			// Step 5: dfs the arrival's neighors
			dfs2(map, res, arrival, ticketsNum);
			if(ticketsNumUsed == ticketsNum){
				return;
			}

			// Step 6: If the first lexical order in the arrivals is the final end airport, 
			// but we still have some airports left and not be dfs yet, we need recover the previous state and try another arrival
			ticketsNumUsed--;
			arrivals.add(i, arrival);
			res.remove(res.size() - 1);
		}
	}


	public static void main(String[] args){
		String[][] tickets = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		//String[][] tickets = new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		LC332 x = new LC332();
		System.out.println("\n"+x.findItinerary2(tickets));
	}
}