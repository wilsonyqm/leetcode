package leetcode;
import java.util.*;
public class PostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(root==null) return res;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		TreeNode prev=null;
		while(!stack.isEmpty()){
			TreeNode cur=stack.peek();
			if(prev==null || prev.left==cur || prev.right==cur){
				if(cur.left!=null){
					stack.push(cur.left);
				}
				else if(cur.right!=null) stack.push(cur.right);
			}
			else if(cur.left==prev){
				if(cur.right!=null) stack.push(cur.right);
			}
			else if(cur==prev || cur.right==prev){
				res.add(cur.val);
				stack.pop();
			}
			prev=cur;
		}
		return res;
    }
}
