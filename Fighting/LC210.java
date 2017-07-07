/*
210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

import java.util.*;

public class LC210{
	// Time Compelxity: O(N)
	// Runtime: 31ms, beats 32.99%
	public int[] findOrder(int numCourses, int[][] prerequisites){
		if(numCourses == 0)
			return null;

		Queue<Integer> queue = new LinkedList<Integer>();
		int indegree[] = new int[numCourses];
		int order[] = new int[numCourses];
		int index = 0;

		for(int i = 0; i < prerequisites.length; i++){
			indegree[prerequisites[i][0]]++;
		}

		for(int i = 0; i < numCourses; i++){
			if(indegree[i] == 0){
				order[index++] = i;
				queue.offer(i);
			}
		}

		// How many courses don't need prerequisites. 
    	while (!queue.isEmpty()) {
        	int prerequisite = queue.poll(); // Already finished this prerequisite course.
        	for (int i = 0; i < prerequisites.length; i++){
            	if (prerequisites[i][1] == prerequisite) {
                	indegree[prerequisites[i][0]]--; 
                	if (indegree[prerequisites[i][0]] == 0) {
                    	// If indegree is zero, then add the course to the order.
                    	order[index++] = prerequisites[i][0];
                    	queue.offer(prerequisites[i][0]);
                	}
            	} 
        	}
    	}
    	return (index == numCourses) ? order : new int[0];
	}

	public static void main(String[] args){
		LC210 x = new LC210();
		int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		int numCourses = 4;
		int[] order = x.findOrder(numCourses, prerequisites);
		for(int i = 0; i < numCourses; i++)
			System.out.println(order[i]);
	}
}