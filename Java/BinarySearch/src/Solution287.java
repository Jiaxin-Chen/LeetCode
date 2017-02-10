
public class Solution287 {
	/*
	 * 287. Find the Duplicate Number:
	 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. 
	 * Assume that there is only one duplicate number, find the duplicate one.
	 */
	
	public int findDuplicate1(int[] nums){
		if(nums == null || nums.length < 2){
			return 0;
		}
		
		int slow = nums.length - 1;
		int fast = slow, finder = slow;
		
		while(true){
			slow = nums[slow];
			fast = nums[nums[fast]];
			if(slow == fast){
				break;
			}
		}
		
		while(true){
			slow = nums[slow];
			finder = nums[finder];
			if(slow == finder){
				return finder;
			}
		}
	}
	
	// Time O(NlogN), space O(1)
	public int findDuplicate2(int[] nums){
		int start = 1, end = nums.length - 1, mid = 0, count = 0;
		
		while(start < end){
			mid = start + (end - start) / 2;
			count = 0;
			for(int i = 0; i < nums.length; i++){
				if(nums[i] <= mid){
					count++;
				}
			}
			if(count <= mid){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		return end;  //It's okay to return start or end here, because end = start in the end;
	}
	
	
	public static void main(String[] args){
		int[] nums = {1, 1, 2};
		Solution287 res = new Solution287();
		System.out.println(res.findDuplicate2(nums));
	}
}
