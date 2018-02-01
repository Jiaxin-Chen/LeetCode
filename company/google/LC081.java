/*
81. Search in Rotated Sorted Array II

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
*/

class LC081{
	// Binary Search
	// Time Complexity: O(logN)
	public boolean search(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return false;
		}

		int left = 0, right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){
				return true;
			}

			// the only difference from the first one, trickly case, just updat left and right
			if(nums[left] == nums[mid] && nums[right] == nums[mid]){
				left++;
				right--;
			}
			// if the first half is in order
			else if(nums[left] <= nums[mid]){
				// if target in the range of [left, mid-1] (nums[left]<=target < nums[mid]), if so, do search in the first half,
				if(nums[left] <= target && nums[mid] > target){
					right = mid - 1;
				// if not, search in the second half 
				}else{
					left = mid + 1;
				}
			// if the second half in order
			}else{
				// check if target in the range of [mid+1, right] (nums[mid]<target <= nums[right]), if so, do search in the second half
				if(nums[right] >= target && nums[mid] < target){
					left = mid + 1;
				// if not, search in the second half 
				}else{
					right = mid - 1;
				}
			}

		}
		return false;
	}

	//----------------------------------------------------------------------
	// My fault version: failed for the case 2 in the main function
	public boolean search2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
			return false;
		}

		int left = 0, right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] == nums[right]){
				right--;
			}else if(nums[mid] > nums[right]){
				left = mid + 1;
			}else{
				right = mid;
			}
		}

		int minIdx = left;
		System.out.println(minIdx);
		left = 0;
		right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			int realMid = (mid + minIdx) % nums.length;
			if(nums[realMid] == target){
				return true;
			}else if(nums[realMid] == nums[right]){
				right--;
			}else if(nums[realMid] < target){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return false;
    }

    public static void main(String[] args){
    	LC081 obj = new LC081();
    	// Case 1:
    	//int[] nums = new int[]{2, 2, 2, 0, 2, 2};
    	//int target = 0;

    	// Case 2:
    	//int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    	//int target = 2;

    	// Case 3:
    	int[] nums = new int[]{3, 1};
    	int target = 3;
    	
    	System.out.println(obj.search(nums, target));
    }
}