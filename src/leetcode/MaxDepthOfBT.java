package leetcode;

public class MaxDepthOfBT {
	public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return helper(root,1,0);
    }
	private int helper(TreeNode node,int k,int max){
		if(node==null) return max;
		if(node.left==null && node.right==null) return Math.max(k,max);
		max=helper(node.left,k+1,max);
		max=helper(node.right,k+1,max);
		return max;
	}
	//what if it is not binary tree, but tree with a lot of branches
	private int helperwithMultipleNodes(TreeNode tree){
		int deepest=0;
		//for (child of root node)
			//deepest=Math.max(deepest, helperwithMultipleNodes(child));
		return deepest+1;
	}
}
