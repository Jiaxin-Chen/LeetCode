/*
406. Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

import java.util.*;

class LC406{
	/*
	Pick out tallest group of people and sort them in a subarray (S). Since there’s no other groups of people taller than them, therefore each guy’s index will be just as same as his k value.
	For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
	E.g.
	input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	subarray after step 1: [[7,0], [7,1]]
	subarray after step 2: [[7,0], [6,1], [7,1]]
	*/

	// Time Complexity: O(nlogn)
	// Runtime: 79ms, beats 33.25%
	public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }
        
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        
        ArrayList<int[]> res = new ArrayList<>();
        for(int[] cur : people){
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    
    }

    public static void main(String[] args){
    	LC406 obj = new LC406();
    	int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    	int[][] res = obj.reconstructQueue(people);
    	System.out.println("----------");
    	for(int i = 0; i < res.length; i++){
    		
    		System.out.println(res[i][0] + ", " + res[i][1]);
    		
    	}
    }
}