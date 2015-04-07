package leetcode;

public class BalanceBinaryTree {
	public boolean BalanceBinaryTreeMethod(TreeNode root){
		return helper(root)!=-1;
	}
	public int helper(TreeNode root){
		if(root==null) return 0;
		int left=helper(root.left);
		int right=helper(root.right);
		if(left==-1||right==-1||Math.abs(left-right)>1) return -1;
		return Math.max(left, right)+1;
	}
	//insert is used for tests;
	//recursion call is better;
	public void insert(TreeNode parent,TreeNode root,int l_or_r,int element){
	    if(root == null){
	        root = new TreeNode(element);
	        if(l_or_r==0) parent.left=root;
	        else if(l_or_r==1) parent.right=root;
	        return;
	    }
	    TreeNode runner = root;
	    
	        if(runner.val > element){
	            insert(runner,runner.left,0,element);
	        } else {
	            insert(runner,runner.right,1,element);
	        }
	}
	
	public static void main(String args[]){
		BalanceBinaryTree tree= new BalanceBinaryTree();
		TreeNode root=new TreeNode(10);
		int[] arrs= new int[]{8,7,6,9,12,11,13,14};
		for(int arr:arrs){
			tree.insert(root,root,-1,arr);
			System.out.println("Insert Node: "+arr);
		}
		boolean res=tree.BalanceBinaryTreeMethod(root);
		System.out.println("Is it a Balanced Tree? "+res);
	}
}
