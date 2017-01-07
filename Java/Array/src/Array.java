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
		System.out.println("\nOutput Array:");
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
		int target = 9;
		int arrayLength;
		//int[] nums = inputArray(arraySize);
		//arrayLength = Solution26.removeDuplicates(nums);
		//arrayLength = Solution80.removeDuplicates2(nums);
		//int[] index = Solution167.twoSum(nums, target);

		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> result = Solution448.findDisappearedNumbers(nums);
		//outputArray(index);
		outputArrayList(result);
	}

}
