/*
207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

import java.util.*;

public class LC207{
	// BST
	// Time Complexity: O(N)
	// Runtime: 55ms, beats 28.39%
	public boolean canFinish(int numCourses, int[][] prerequisites){
		int[][] matrix = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];

		for(int i = 0; i < prerequisites.length; i++){
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if(matrix[pre][ready] == 0)
				indegree[ready]++; //duplicate case
			matrix[pre][ready] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < indegree.length; i++){
			if(indegree[i] == 0)
				queue.offer(i);
		}

		while(!queue.isEmpty()){
			int course = queue.poll();
			count++;
			for(int i = 0; i < numCourses; i++){
				if(matrix[course][i] != 0){
					if(--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;
	}

	public boolean canFinish2(int numCourses, int[][] prerequisites){
		if (numCourses == 0) 
			return false;

    	// Convert graph presentation from edges to indegree of adjacent list.
    	int indegree[] = new int[numCourses];
    	//int order[] = new int[numCourses];
    	int index = 0;

    	for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
        	indegree[prerequisites[i][0]]++;    

    	Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < numCourses; i++){ 
        	if (indegree[i] == 0) {
            	// Add the course to the order because it has no prerequisites.
            	//order[index++] = i;
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
                    	//order[index++] = prerequisites[i][0];
                    	queue.offer(prerequisites[i][0]);
                	}
            	} 
        	}
    	}

    	return (index == numCourses);
	}
}