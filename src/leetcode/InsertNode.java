package leetcode;

public class InsertNode {
	public TreeNode insertNode(TreeNode root, TreeNode node){
		if(root==null) return node;
		if(root.val<node.val){
			root.right=insertNode(root.right,node);
		}
		else root.left=insertNode(root.left,node);
		return node;
	}
	//this is a good typical bottom up example, there has to be a return value, and construction a graph, u need to
	//use the return value;
}
