/*
329. Longest Increasing Path in a Matrix

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

class LC329{
	
	// DFS
	// Time Complexity: O(MN)
	// TLE...
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		int len = dfs(matrix, i, j, m, n, visited);
        		res = Math.max(res, len);
        	}
        }
        return res;
    }

    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int dfs(int[][] matrix, int i, int j, int m, int n, boolean[][] visited){
    	int len = 1;

    	visited[i][j] = true;

    	for(int[] dir : directions){
    		int x = i + dir[0];
    		int y = j + dir[1];

    		if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j] && !visited[x][y]){
    			len = Math.max(len, dfs(matrix, x, y, m, n, visited) + 1);
    		}
    	}
    	visited[i][j] = false;
    	return len;
    }

    //------------------------------------------------------------------------
    // Optimization: use cache instead of visited to record distance to avoid some useless visiting
    // Time Complexity: O(mn)
    // Runtime: 15ms, beats 59.62%
    public int longestIncreasingPath2(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        //boolean[][] visited = new boolean[m][n];
        int[][] cache = new int[m][n]; // instead of using visited, use cache to record the distance because it’s highly possible to revisit a cell

        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		int len = dfs(matrix, i, j, m, n, cache);
        		res = Math.max(res, len);
        	}
        }
        return res;
    }

    //private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache){
    	if(cache[i][j] != 0){
    		return cache[i][j];
    	}

    	int len = 1;

    	//visited[i][j] = true;

    	for(int[] dir : directions){
    		int x = i + dir[0];
    		int y = j + dir[1];

    		if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
    			len = Math.max(len, dfs(matrix, x, y, m, n, cache) + 1);
    		}
    	}
    	//visited[i][j] = false;
    	cache[i][j] = len;
    	return len;
    }


    public static void main(String[] args){
    	LC329 obj = new LC329();
    	int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    	System.out.println(obj.longestIncreasingPath2(matrix));
    }
}