
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		x = val;
	}
}

class test{
	public List<List<Integer>> verticalOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}

		Map<TreeNode, Integer> vorders = new HashMap<>();
		Map<Integer, ArrayList<TreeNode>> ans = new TreeMap<>();
		getVOrders(vorders, root);
		initAns();

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()){
			int size = q.size();
			TreeNode head = q.poll();
			ans.get(vorders.get(head)).add(head);

			for(int i = 0; i < size(); i++){
				if(head.left != null){
					q.offer(head.left);
				}
				if(head.right != null){
					q.offer(head.right);
				}
			}
		}
		convertAnsToRes(ans, res);
		return res;
	}

	private int left = 0; 
	private int right = 0;

	private void getVOrder(Map<TreeNode, Integer> vorders, TreeNode root){
		helper(vorders, root, 0);
	}
}