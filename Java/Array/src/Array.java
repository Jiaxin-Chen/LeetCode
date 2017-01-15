import java.util.*;

public class Array {

	
	public static int[] inputArray(int arraySize){
		int[] nums = new int[arraySize];
		System.out.println("Input Array:");
		Scanner in = new Scanner(System.in);
		if(in.hasNextInt()){
			nums[0] = in.nextInt();
		}
		
		int i = 1;
		while(in.hasNextInt() && i < arraySize){
			nums[i++] = in.nextInt();
		}
		return nums;
	}
	
	public static void outputArray(int[] nums){
		System.out.println("\nOutput Array:");
		System.out.print("nums = [");
		for (int i = 0; i < nums.length; i++){
			if (i != nums.length - 1)
				System.out.print(nums[i] + ", ");
			else
				System.out.println(nums[i] + "]");
		}
	}
	
	public static void outputArrayList(List<Integer> result){
		System.out.println("\nOutput ArrayList:");
		System.out.print("result = [");
		for (int i = 0; i < result.size(); i++){
			if (i != result.size() - 1)
				System.out.print(result.get(i) + " ");
			else
				System.out.println(result.get(i) + "]");
		}
	}
	
	
	public static void main(String[] args){
		int arraySize = 8;
		
		//int[] nums = inputArray(arraySize);
		//int arrayLength = Solution26.removeDuplicates(nums);
		//int arrayLength = Solution80.removeDuplicates2(nums);
		
		
		/* 
		 * int target = 9;
		 * int[] index = Solution167.twoSum(nums, target);
		 * outputArray(index);
		 */

		/*
		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> result = Solution448.findDisappearedNumbers(nums);
		outputArrayList(result);
		*/
		
		/*
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 13;
		Solution189.rotate(nums, k);
		outputArray(nums);
		*/
		
		/*
		int[] nums1 = {1, 3, 5, 7, 9, 0, 0, 0};
		int[] nums2 = {2, 4, 6};
		int m = 5, n = 3;
		Solution88.merge(nums1, m, nums2, n);
		outputArray(nums1);
		*/
		
		/*
		int[] nums = {1, 2, 3, 4};
		int[] nums = {1, 1, 2147483647};
		int moveSteps = Solution453.minMoves(nums);
		outputArray(nums);
		System.out.println(moveSteps);
		*/
		
		/*
		int[] nums = {1, 2, 3, 4};
		int moveSteps = Solution462.minMoves2(nums);
		outputArray(nums);
		System.out.println(moveSteps);
		*/
		
		/*
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;
		int kthLargestEle = Solution215.findKthLargest(nums, k);
		System.out.println(kthLargestEle);
		*/
		
		/*
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		//int[] result = Solution349.intersection(nums1, nums2);
		int[] result = Solution350.intersetion2(nums1, nums2);
		outputArray(result);
		*/
		
		/*
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> result = Solution442.findDuplicates(nums);
		outputArrayList(result);
		outputArray(nums);
		*/
		
		/*
		int[] nums = {1, 2, 3, 4};
		int[] result = Solution238.productExceptSelf(nums);
		outputArray(result);
		*/
		
		/*
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int result = Solution153.findMin(nums);
		System.out.println(result);
		*/
		
		/*
		int[] nums = {3, 3, 1, 3, 3};
		int result = Solution154.findMin2(nums);
		System.out.println(result);
		*/
		
		/*
		int[] nums = {3, 3, 1, 2, 3};
		int target = 4;
		boolean result = Solution81.search(nums, target);
		System.out.println(result);
		*/
		
		/*
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		Solution384 obj = new Solution384(nums);
		int[] param2 = obj.shuffle();
		outputArray(param2);
		int[] param1 = obj.reset();
		outputArray(param1);
		*/
		
		int[] nums = {1, 2, 3, 4, 5};
		int s = 15;
		int result = Solution209.minSubArrayLen2(s, nums);
		System.out.println(result);;
	}

}
