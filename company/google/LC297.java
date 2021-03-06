/*
297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
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

// Runtime: 27ms, beats 41.51%
class LC297{
	// Time Complexity: O(N)
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
        	return "#";
        }
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Time Complexity: O(N)
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	// queue records all the nodes in pre-order
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue){
    	String val = queue.poll();
    	if(val.equals("#")){
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(val));
    	root.left = deserialize(queue);
    	root.right = deserialize(queue);
    	return root;
    }

    public static void main(String[] args){
    	LC297 codec = new LC297();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.right.left = new TreeNode(4);
    	root.right.right = new TreeNode(5);

    	String serial = codec.serialize(root);
    	System.out.println(serial);
    	//TreeNode deserial = codec.deserialize(serial);
    }
}