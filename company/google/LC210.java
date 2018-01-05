/*
210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. 

If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. 
Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

import java.util.*;

class LC210{
	// BFS
	// Time Complexity: O(Vertex + Edge)
	// Runtime: 55ms, beats 13.62%
	public int[] findOrder(int numCourses, int[][] prerequisites){
		int[] courseOrder = new int[numCourses];
		int[] indegree = new int[numCourses];      // indicates the number of incomming edges for each node
		Queue<Integer> queue = new LinkedList<>(); // contains all nodes with no incomming edges
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

		int idx = 0;
		while(!queue.isEmpty()){
			int course = queue.poll();
			courseOrder[idx++] = course;

			for(int[] prerequisite : prerequisites){
				// Step 3: for each node has the incomming edge with the course, its indegree minus 1
				if(prerequisite[1] == course){
					indegree[prerequisite[0]]--;
					edgeNum--;

					// Step 4: If the node has no incomming edge any more, add into the queue
					if(indegree[prerequisite[0]] == 0){
						queue.add(prerequisite[0]);
					}
				}
			}
		}
		
		// Step 5: If the graph has no edge, return the courseOrder
		return (edgeNum == 0) ? courseOrder : new int[0];
	}


//------------------------------------------------------------------------------------------------------------
	
	// DFS
	// Time Complexity: O(V + E)
	// Runtime: 39ms, beats 21.26%
	public int[] findOrder2(int numCourses, int[][] prerequisites){
		int[] courseOrder = new int[numCourses];
		List<List<Integer>> courses = new LinkedList<>();

		// Step 1: Construct the directed graph
		for(int i = 0; i < numCourses; i++){
			courses.add(new LinkedList<Integer>());
		}
		for(int[] prerequisite : prerequisites){
			courses.get(prerequisite[0]).add(prerequisite[1]);
		}

		// 0: unvisited, 1: visiting, 2: visited
		int[] visited = new int[numCourses];

		// Step 2: traverse all the course
		for(int course = 0; course < numCourses; course++){
			if(!DFS(course, courses, visited, courseOrder)){
				return new int[0];
			}
		}
		return courseOrder;
	}

	private int courseIdx = 0;

	private boolean DFS(int course, List<List<Integer>> courses, int[] visited, int[] courseOrder){
		
		// Step3: 
		// if visit = 2, which means the subtree whose root is i has been dfs traversed and all the nodes in subtree 
		// has been put in the result(if we request), so we do not need to traverse it again
		if(visited[course] == 2){
			return true;
		}
		// Step 4: course has been visited while visiting its children - cycle !!!!
		if(visited[course] == 1){
			return false;
		}

		// Step 5: mark this course is being visited, and get the preCourses
		visited[course] = 1;
		List<Integer> preCourses = courses.get(course);

		// Step 6: dfs its children preCourse
		for(int i = 0; i < preCourses.size(); i++){
			if(!DFS(preCourses.get(i), courses, visited, courseOrder)){
				return false;
			}
		}
		//System.out.println("courseOrder[" + courseIdx + "] = " + course);
		
		// Step 7: mark the visiting done and add into courseOrder
		visited[course] = 2;
		courseOrder[courseIdx++] = course;

		return true;
	}


	public static void main(String[] args){
		LC210 x = new LC210();
		int[][] prerequisites = new int[][]{{3, 0}, {0, 1}};
		int numCourses = 4;

		int[] courseOrder = x.findOrder2(numCourses, prerequisites);
		for(int i = 0; i < numCourses; i++){
			System.out.println(courseOrder[i]);
		}

	}
}