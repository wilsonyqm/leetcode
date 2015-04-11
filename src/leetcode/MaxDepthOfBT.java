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
}
