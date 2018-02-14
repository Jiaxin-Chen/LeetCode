/*
103. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LC103 {
	// bfs + queue
	// Time Complexity: O(N)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
       
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isZigZag = true; // JUST ADD the isZigZag flag!
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(isZigZag){
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(new LinkedList<Integer>(list));
            isZigZag = !isZigZag;
        }
        return res;
    }
}