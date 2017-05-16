
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
	
	private TreeNode root;
	
	public void insert(int value){
		TreeNode node = new TreeNode(value);
		
		if(root == null){
			root = node;
			return;
		}
	}
	
	public static void main(String[] args){
		 Solution404 res = new Solution404();
		 
	 }
}
