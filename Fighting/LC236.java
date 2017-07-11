/*
236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
between two nodes v and w as the lowest node in T that has both v and w as descendants 
(where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
Another example is LCA of nodes 5 and 4 is 5, since a node can be 
a descendant of itself according to the LCA definition.
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


public class LC236{
	// Time Complexity: O(N)
	// Runtime: 27ms, beats 7.06%
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || p == null || q == null)
			return root;

		Map<TreeNode, TreeNode> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Set<TreeNode> set = new HashSet<>();
		map.put(root, null);
		queue.offer(root);

		while(!map.containsKey(p) || !map.containsKey(q)){
			TreeNode node = queue.poll();
			if(node.left != null){
				map.put(node.left, node);
				queue.offer(node.left);
			}
			if(node.right != null){
				map.put(node.right, node);
				queue.offer(node.right);
			}
		}

		while(p != null){
			set.add(p);
			p = map.get(p);
		}

		while(!set.contains(q))
			q = map.get(q);

		return q;
	}


	// Time Complexity: O(N)
	// Runtime: 12ms, beats 39.94%
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || root == p || root == q)  
			return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   
        	return root;
        return left != null ? left : right;
	}
}