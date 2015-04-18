package leetcode;

public class IsValidBST {
	public boolean isValidBST(TreeNode root){
		if(root==null) return true;
		return valid(root,null,null);//use integer null to eliminate the difference
	}
	public boolean valid(TreeNode root,Integer low,Integer hi){
		if(root==null) return true;
		return (low==null || root.val>low) && (hi==null || root.val<hi)  && 
				valid(root.left,low,root.val) && valid(root.right,root.val,hi);
	}
}
