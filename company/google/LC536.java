/*
536. Construct Binary Tree from String

You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".
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

class LC536{
	// Iterative:
	// Time Complexity: O(N)
	// Runtime: 31ms, beats 67.87%
	public TreeNode str2tree(String s){
		if(s == null || s.length() == 0){
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		char[] ch = s.toCharArray();
		for(int i = 0, j = i; i < ch.length; i++, j = i){
			// Step 1: cur node is useless
			if(ch[i] == ')'){
				stack.pop();
			}
			else if(ch[i] >= '0' && ch[i] <= '9' || ch[i] == '-'){
				// Step 2: get current node val
				while(i + 1 < ch.length && ch[i+1] >= '0' && ch[i+1] <= '9'){
					i++;
				}
				TreeNode cur = new TreeNode(Integer.valueOf(s.substring(j, i+1)));

				// Step 3: Construct the subtree
				if(!stack.isEmpty()){
					TreeNode parent = stack.peek();
					// left child node
					if(parent.left == null){
						parent.left = cur;
					// right child node
					}else{
						parent.right = cur;
					}
				}
				stack.push(cur);
			}
		}
		return stack.peek();
	}

	public String printTree(TreeNode root){
		if(root == null){
			return "null";
		}
		return root.val + ", " + printTree(root.left) + ", " + printTree(root.right);
	}

	public static void main(String[] args){
		String s = "4(2(3)(1))(6(5))";
		LC536 x = new LC536();
		TreeNode root = x.str2tree(s);
		System.out.println(x.printTree(root));
	}

}