

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val = x;
	}
	
	public int preIdx = 0;
	
	
	public TreeNode buildTree(int[] preOrder, int val, int min, int max){
		if(preIdx < preOrder.length){
			if(preOrder[preIdx] > min && preOrder[preIdx] < max){
				TreeNode root = new TreeNode(val);
				preIdx++;
				if(preIdx < preOrder.length){
					root.left = buildTree(preOrder, preOrder[preIdx], min, val);
					root.right = buildTree(preOrder, preOrder[preIdx], val, max);
				}
				return root;
			}
		}
		return null;
	}
	/*
	public TreeNode buildTree(int[] order, int val){
		if(preIdx < order.length){
			TreeNode root = new TreeNode(val);
			preIdx++;
			//root.left = buildTree(order, )
		}
	}*/
	
	public void displayTreeNode(TreeNode root){
		if(root != null){
			displayTreeNode(root.left);
			System.out.print(root.val + " ");
			displayTreeNode(root.right);
		}
	}

	
}
