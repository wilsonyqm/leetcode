package leetcode;

public class SysmetricTree {
	 public boolean isSymmetric(TreeNode root) {
	        if (root == null)
	            return true;
	        return isSymmetric(root, root);

	    }

	    public boolean isSymmetric(TreeNode left, TreeNode right) {
	        if (left == null || right == null) {
	            return left == right;
	        }
	        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	    }

}
