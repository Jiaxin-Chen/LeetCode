/*
134. Gas Station

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 */

public class LC134{
	// Greedy Algorithm
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 10.44%
	public int canCompleteCircuit(int[] gas, int[] cost){
		if(gas.length == 0 || cost.length == 0)
			return -1;
		int start = 0, tank = 0, total = 0;
		for(int i = 0; i < gas.length; i++){
			tank += gas[i] - cost[i];
			if(tank < 0){
				start = i + 1;
				total += tank;
				tank = 0;
			}
		}
		return (total + tank < 0) ? -1 : start;
	}
}