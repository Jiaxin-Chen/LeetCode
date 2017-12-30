/*
449. Serialize and Deserialize BST

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.
    2
   / \
  1   3

as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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

// Runtime: 80ms, beats 7.56%
class LC449{
	// Time Complexity: O(N)
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Because we expect the encoded string should be as compact as possible, we just utilize pre-order
        if(root == null){
        	return null;
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        if(left == null && right == null){
            return root.val + "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if(left != null){
            sb.append("," + left);
        }
        if(right != null){
            sb.append("," + right);
        }
        return sb.toString();
    }

    // Time Complexity: O(N)
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
    	// pre_order records all the nodes in pre-order
        List<String> pre_order = new LinkedList<>(Arrays.asList(data.split(",")));
        int[] preOrder = new int[pre_order.size()];
        int[] inOrder = new int[pre_order.size()];

        for(int i = 0; i < preOrder.length; i++){
            preOrder[i] = Integer.valueOf(pre_order.get(i));
            // we cannot use inOrder = preOrder directly, because it's shadow copy, they will point to the same memory
            inOrder[i] = preOrder[i];
        }
        
        Arrays.sort(inOrder);
        return deserialize(preOrder, inOrder, 0, 0, inOrder.length - 1);
    }

    // Construct the tree from preOrder and inOrder
    private TreeNode deserialize(int[] preOrder, int[] inOrder, int preStart, int inStart, int inEnd){
    	if(preStart > preOrder.length - 1 || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);
        int inIdx = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inOrder[i] == preOrder[preStart]){
                inIdx = i;
            }
        }   
        root.left = deserialize(preOrder, inOrder, preStart + 1, inStart, inIdx - 1);
        root.right = deserialize(preOrder, inOrder, preStart + inIdx - inStart + 1, inIdx + 1, inEnd);
        return root;
    }

    public static void main(String[] args){
    	LC449 codec = new LC449();
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(3);
    	

    	String serial = codec.serialize(root);
    	System.out.println(serial);
    	TreeNode deserial = codec.deserialize(serial);
    }
}