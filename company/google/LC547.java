/*
547. Friend Circles
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
*/

import java.util.*;

class LC547{

	// DFS:
	// Time Complexity: O(N^2), Roughly...
	// Runtime: 10ms, beats 84.55%
	public int findCircleNum(int[][] M){
		if(M == null || M.length == 0 || M[0].length == 0){
        	return 0;
        }
        int N = M.length;
        int count = 0;
        boolean[] visited = new boolean[N]; //visited[i] means if ith person is visited in the dfs

        for(int i = 0; i < N; i++){
        	if(!visited[i]){
        		dfs(i, M, visited);
        		count++;
        	}
        }
        return count;
	}

	private void dfs(int student, int[][] M, boolean[] visited){
		for(int friend = 0; friend < M.length; friend++){

			//We found an unvisited person in the current friend cycle 
			if(M[student][friend] == 1 && !visited[friend]){
				visited[friend] = true;
				dfs(friend, M, visited); //Start DFS on this new found person
			}
		}
	}

	public int findCircleNum2(int[][] M){
		if(M == null || M.length == 0 || M[0].length == 0){
        	return 0;
        }
        int N = M.length;
        int count = N;

        int[] parents = new int[N];
        for(int i = 0; i < N; i++){
        	parents[i] = i;
        }

        for(int i = 0; i < N; i++){
        	for(int j = i + 1; j < N; j++){
        		if(M[i][j] == 1){
        			int root1 = getRoot(i, parents);
        			int root2 = getRoot(j, parents);
        			if(root1 != root2){
        				parents[root1] = root2;
        				count--;
        			}
        		}
        	}
        }
        return count;
	}

	private int getRoot(int idx, int[] parents){
		while(idx != parents[idx]){
			idx = parents[idx];
		}
		return idx;
	}


//--------------------------------------------------------------------
	// My fault version: ...... too may duplicates
	public int findCircleNum3(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0){
        	return 0;
        }
        int N = M.length;
        int count = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        // construct the graph
        for(int i = 0; i < N; i++){
        	for(int j = i+1; j < N; j++){
        		map.putIfAbsent(i, new HashSet<>());
        		map.putIfAbsent(j, new HashSet<>());
        		map.get(i).add(j);
        		map.get(j).add(i);
        	}
        }

        // My fault version: we cannot do this! because there may be some duplicates if we dfs [1, 3] and then [3, 1]
        for(int i = 0; i < N; i++){
        	for(int j = i+1; j < N; j++){
        		if(!visited.contains(i)){
        			dfs(i, j, map, visited);
        			count++;
        		}
        	}
        }
        return count;
    }

    private boolean dfs(int i, int j, Map<Integer, Set<Integer>> map, Set<Integer> visited){
    	Set<Integer> friends = map.get(i);
    	if(friends.contains(j)){
    		return true;
    	}

    	visited.add(i);
    	for(Integer friend : friends){
    		if(!visited.contains(friend)){
    			dfs(friend, j, map, visited);
    			return true;
    		}
    	}
    	return false;
    }

    public static void main(String[] args){
    	LC547 obj = new LC547();
    	int[][] M = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
    	System.out.println(obj.findCircleNum2(M));
    }
}