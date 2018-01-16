/*
300. Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

class LC300{
	// Time Complexity: O(N^2), Space Complexity: O(N)
	// Runtime: 35ms, beats 19.52%
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }

        int[] dp = new int[nums.length]; // dp[i] indicates the longest length in the position i
        int maxLen = 1;

        for(int i = 0; i < nums.length; i++){
        	dp[i] = 1;
        	for(int j = 0; j < i; j++){
        		if(nums[j] < nums[i]){
        			// But increase the value only if it results in a larger value of the sequence than dp[i]
					// It is possible that dp[i] already has larger value from some previous j'th iteration
        			dp[i] = (dp[i] > dp[j] + 1) ? dp[i] : dp[j] + 1;
        		}
        	}
        	maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

//---------------------------------------------------------------------
    // Time Complexity: O(NlogN), Space Complexity: O(N)
    public int lengthOfLIS2(int[] nums){
    	// minLast means find the last 
    	int[] minLast = new int[nums.length + 1];
    	minLast[0] = Integer.MAX_VALUE;

    	for(int i = 1; i <= nums.length; i++){
    		minLast[i] = Integer.MAX_VALUE;
    	}

    	for(int i = 0; i < nums.length; i++){
    		int idx = binarySearch(minLast, nums[i]);
    		System.out.println("idx = " + idx);
    		minLast[idx] = nums[i];
    	}

    	// the result array should be from minLast[1] to minLast[i]
    	int len = 0;
    	for(int i = nums.length; i >= 1; i--){
    		if(minLast[i] != Integer.MAX_VALUE){
    			len = i;
    			break;
    		}
    	}
    	int[] res = getResult(minLast, len); // [2, 3, 7, 18]
    	for(int i = 0; i < res.length; i++){
    		System.out.println(res[i]);
    	}
    	return len;
    }


    private int binarySearch(int[] minLast, int num){
    	int start = 0, end = minLast.length - 1;
    	while(start + 1 < end){
    		int mid = start + (end - start) / 2;
    		if(minLast[mid] < num){
    			start = mid;
    		}else{
    			end = mid;
    		}
    	}
    	return end;
    }

//------------------------------------------------------------------
  	// Follow up: output one of the result
    private int[] getResult(int[] minLast, int len){
    	int[] res = new int[len];
    	int idx = len - 1;
    	for(int i = minLast.length-1; i >= 1; i--){
    		if(minLast[i] != Integer.MAX_VALUE){
    			res[idx--] = minLast[i];	
    		}
    	}
    	return res;

    }

    public static void main(String[] args){
    	LC300 x = new LC300();
    	int[] nums = new int[]{10, 9, 2, 5, 7,3, 101, 18};
    	System.out.println(x.lengthOfLIS2(nums));
    }
}