/*
545. Boundary of Binary Tree

Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1
Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
Example 2
Input:
    ____1_____
   /          \
  2            3
 / \          / 
4   5        6   
   / \      / \
  7   8    9  10  
       
Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
*/

import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC545{
	public List<Integer> boundaryOfBinaryTree(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		res.add(root.val);

		leftBoundary(res, root.left);
		// don't use bottomBoundary(res, root) because we don't want the duplicates of root.val
		bottomBoundary(res, root.left);
		bottomBoundary(res, root.right);
		rightBoundary(res, root.right);

		return res;
	}

	// pre-order
	private void leftBoundary(List<Integer> res, TreeNode root){
		// because we consider all the leaves as the bottom boundary
		if(root == null || (root.left == null && root.right == null)){
			return;
		}
		res.add(root.val);
		if(root.left == null){
			leftBoundary(res, root.right);
		}else{	
			leftBoundary(res, root.left);
		}
	}

	// post-order
	private void rightBoundary(List<Integer> res, TreeNode root){
		if(root == null || (root.left == null && root.right == null)){
			return;
		}
		if(root.right == null){
			rightBoundary(res, root.left);
		}else{
			rightBoundary(res, root.right);
		}
		res.add(root.val);
	}

	private void bottomBoundary(List<Integer> res, TreeNode root){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			res.add(root.val);
			return;
		}
		bottomBoundary(res, root.left);
		bottomBoundary(res, root.right);
	}

//---------------------------------------------------------------------
	// Code optimization:
	public List<Integer> boundaryOfBinaryTree2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root != null){
			res.add(root.val);
			getBoundary(res, root.left, true, false);
			getBoundary(res, root.right, false, true);
		}
		return res;
	}

	private void getBoundary(List<Integer> res, TreeNode root, boolean leftBoundary, boolean rightBoundary){
		if(root == null){
			return;
		}

		// Preorder: if node is left boundary, add it before 2 children
		if(leftBoundary){
			res.add(root.val);
			System.out.println("left = " + root.val);
		}

		// Leaf node: bottom boundary
		if(!leftBoundary && !rightBoundary && root.left == null && root.right == null){
			res.add(root.val);
			System.out.println("bottom = " + root.val);
		}
		
		// node.left is left bound if node is left bound;
		// node.right could also be left bound if node is left bound && node has no right child;
		getBoundary(res, root.left, leftBoundary, rightBoundary && root.right == null);
		getBoundary(res, root.right, leftBoundary && root.left == null, rightBoundary);
		
		/*
		// Fault code: we need consider about the bottom boundary, 
		// otherwise node like 5 in the test case will appear on the left boundary
		getBoundary(res, root.left, leftBoundary, rightBoundary );
		getBoundary(res, root.right, leftBoundary , rightBoundary);
		*/

		// Postorder: if node is right boundary, add it after 2 children
		if(rightBoundary){
			res.add(root.val);
			System.out.println("right = " + root.val);
		}
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		
		LC545 x = new LC545();
		System.out.println(x.boundaryOfBinaryTree2(root));
	}
}