/*
652. Find Duplicate Subtrees

Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1: 
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.
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

class LC652{
	// Time Complexity: O(N)
	// Runtime: 46ms ,beats 32.08%
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        serialize(root, new HashMap<String, Integer>(), res);
        return res;
    }

    private String serialize(TreeNode root, Map<String, Integer> map, List<TreeNode> res){
    	// indicates the leaf of current subtree
    	if(root == null){
    		return "#";
    	}
    	// the sequence is pre-order
    	String preOrder = String.valueOf(root.val) + "," + serialize(root.left, map, res) + "," + serialize(root.right, map, res);
    	// Cannot use map.containsKey(preOrder): avoid duplicates in the res list
    	// Cannot use map.get(preOrder): what if the preOrder isn't in the map, which causes bugs
    	if(map.getOrDefault(preOrder, 0) == 1){
    		res.add(root);
    	}
    	map.put(preOrder, map.getOrDefault(preOrder, 0) + 1);
    	return preOrder;
    }

    public static void main(String[] args){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(4);
    	root.right = new TreeNode(3);
    	root.right.left = new TreeNode(2);
    	root.right.left.left = new TreeNode(4);
    	root.right.right = new TreeNode(4);

    	LC652 x = new LC652();
    	List<TreeNode> res = x.findDuplicateSubtrees(root);
    }
}