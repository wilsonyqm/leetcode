package leetcode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
		
		return helper(0,num.length-1,num);
    }
	public TreeNode helper(int left, int right,int[] num){
		if(left>right) return null;
		int mid=left+(right-left)/2;
		TreeNode node=new TreeNode(-1);
		node.left=helper(left,mid-1,num);
		node.val=num[mid];
		node.right=helper(mid+1,right,num);
		return node;
	}
}
