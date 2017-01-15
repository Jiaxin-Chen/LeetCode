
public class Solution108 {
	/* 108. Convert Sorted Array to Binary Search Tree:
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	
	public static TreeNode sortedArrayToBST(int[] nums){
		if(nums.length == 0 || nums == null){
			return null;
		}
		
		TreeNode root = BST(nums, 0, nums.length - 1);
		return root;
	}
	
	public static TreeNode BST(int[] nums, int start, int end){
		if (start > end){
			return null;
		}
		int mid = (start + end) / 2;
		
		TreeNode node = new TreeNode(nums[mid]);
		node.left = BST(nums, start, mid - 1);
		node.right = BST(nums, mid + 1, end);
		return node;
	}
}
