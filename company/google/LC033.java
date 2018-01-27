/*

33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

class LC033{
	// Time Complexity: O(logN)
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0){
			return -1;
		}

		int left = 0, right = nums.length - 1;

		// Binary search to find minIdx
		// we don't have to let left <= right here, because if nums=[1], it will easily lead to minIdx = left = 0
		while(left < right){
			int mid = left + (right - left) / 2;
			if(nums[mid] > nums[right]){
				left = mid + 1;
			}else{
				right = mid;
			}
		}

		int midIdx = left;
		left = 0;
		right = nums.length - 1;

		// Binary search to find target idx
		// we need use left <= right to search target to avoid the corner case nums = [1], target = 1
		while(left <= right){
			int mid = left + (right - left) / 2;
			int realMid = (mid + midIdx) % nums.length;
			if(nums[realMid] == target){
				return realMid;
			}else if(nums[realMid] < target){
				left = mid + 1;
			}else{
				// if we use left <= right, we need use right = mid - 1, 
				// because the loop will go into the infinite when it reach to left = mid = right
				right = mid - 1;
			}
		}
		return -1;
    }

    //----------------------------------------------------------------------------------------
    // Optimization: just one binary search
    // Time Complexity: O(logN)
    public int search2(int[] nums, int target) {
     if(nums == null || nums.length == 0){
			return -1;
		}

		int left = 0, right = nums.length - 1;
		while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }

            // If contains duplicates in the sorted array, just add this two lines
            /*
            if(nums[left] == nums[mid] && nums[right] == nums[mid]){
				left++;
				right--;
			}*/

            else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[right] >= target && nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
		return -1;
    }

    public static void main(String[] args){
    	LC033 obj = new LC033();
    	//int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    	//int target = 6;
    	int[] nums = new int[]{1};
    	int target = 1;
    	System.out.println(obj.search(nums, target));
    }
}