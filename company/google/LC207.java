/*
207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

import java.util.*;

class LC207{
	// BFS
	// Time Complexity: O(V + E)
	// Runtime: 40ms, beats 34.56%
	public boolean canFinish(int numCourses, int[][] prerequisites){
		// Actually we don't have to check the prerequisites, because no prerequisites means we can take all of the courses directly!

		Queue<Integer> queue = new LinkedList<>(); // contains all nodes with no incomming edges
		int[] indegree = new int[numCourses];      // indicates the number of incomming edges for each node
		int edgeNum = prerequisites.length;

		// Step 1: calculate the indegree for each node
		for(int[] prerequisite : prerequisites){
			indegree[prerequisite[0]]++;
		}

		// Step 2: add the node without incomming edge into the queue
		for(int i = 0; i < numCourses; i++){
			if(indegree[i] == 0){
				queue.offer(i);
			}
		}

		while(!queue.isEmpty()){
			int course = queue.poll();

			for(int[] prerequisite : prerequisites){
				// Step 3: for each node has the incomming edge with the course, its indegree minus 1
				if(prerequisite[1] == course){
					edgeNum--;
					indegree[prerequisite[0]]--;

					// Step 4: If the node has no incomming edge any more, add into the queue
					if(indegree[prerequisite[0]] == 0){
						queue.offer(prerequisite[0]);
					}
				}
			}
		}

		// Step 5: If the graph has no edge, return true
		return edgeNum == 0;
	}

//-------------------------------------------------------------------------------------------------

	// DFS
	// Time Complexity: O(V + E)
	// Runtime: 24ms, beats 49.79%
	public boolean canFinish2(int numCourses, int[][] prerequisites){

		// Step 1: create the array lists to represent the courses
		List<List<Integer>> courses = new LinkedList<>();
		for(int i = 0; i < numCourses; i++){
			courses.add(new LinkedList<Integer>());
		}
		// create the directed graph
		for(int[] prerequisite : prerequisites){
			courses.get(prerequisite[0]).add(prerequisite[1]);
		}

		// 0: unvisited, 1: visiting, 2: visited
		int[] visited = new int[numCourses];

		// Step 2: DFS visit each course
		for(int course = 0; course < numCourses; course++){
			if(!DFS(course, courses, visited)){
				return false;
			}
		}
		return true;
	}


	private boolean DFS(int course, List<List<Integer>> courses, int[] visited){
		// Step3: 
		// if visit = 2, which means the subtree whose root is i has been dfs traversed and all the nodes in subtree 
		// has been put in the result(if we request), so we do not need to traverse it again
		if(visited[course] == 2){
			return true;
		}

		// Step 4: preCourse has been visited while visiting its children - cycle !!!!
		if(visited[course] == 1){
			return false;
		}

		// Step 5: mark this course is being visited, and get the preCourses
		visited[course] = 1;
		List<Integer> preCourses = courses.get(course);

		// Step 6: dfs its children preCourse
		for(int i = 0; i < preCourses.size(); i++){			
			if(!DFS(preCourses.get(i), courses, visited)){
				return false;
			}		
		}

		// Step 7: mark the visiting done
		visited[course] = 2;

		return true;
	}



	public static void main(String[] args){
		int[][] prerequisites = new int[][]{{1, 0}};
		int numCourses = 2;

		LC207 x = new LC207();
		System.out.println(x.canFinish2(numCourses, prerequisites));
	}
}