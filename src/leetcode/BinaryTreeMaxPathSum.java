package leetcode;
//Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.
//
//For example:
//Given the below binary tree,
//
//       1
//      / \
//     2   3
//Return 6.
//返回值是最大值，结果是两边最大值加上本身的值，每一个路径都有一个转折点
public class BinaryTreeMaxPathSum {
	int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        l=Math.max(0,l);
        r=Math.max(0,r);
        max=Math.max(max,l+r+root.val);
        return Math.max(l,r)+root.val;
    }
}
