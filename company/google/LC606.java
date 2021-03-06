/*
606. Construct String from Binary Tree

You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC606{
	// Recursive
	// Time Complexity: O(N)
	// Runtime: 41ms, beats 14.48%
	public String tree2str(TreeNode t){
		if(t == null){
			return "";
		}
		String left = tree2str(t.left);
		String right = tree2str(t.right);
		
		if(left.equals("") && right.equals("")){
			return t.val + "";
		}
		//one-to-one mapping relationship for the left child node
		left =  "(" + left + ")";
		right = right.equals("") ? "" : "(" + right + ")";
		return t.val + left + right;
	}


	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);

		LC606 x = new LC606();
		System.out.println(x.tree2str(root));
	}
}