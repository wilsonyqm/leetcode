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
			if(prev==null || prev.left==cur || prev.right==cur){//traverse down the tree
				if(cur.left!=null){
					stack.push(cur.left);
				}
				else if(cur.right!=null) stack.push(cur.right);
			}
			else if(cur.left==prev){//traverse up the tree from left
				if(cur.right!=null) stack.push(cur.right);
			}
			else{//traverse up the tree from right.
				res.add(cur.val);
				stack.pop();
			}
			prev=cur;
		}
		return res;
    }
	public List<Integer> postorderTraversal2(TreeNode root) {
	    List<Integer> ans = new LinkedList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    if (root != null) stack.push(root);
	    HashSet<TreeNode> visited = new HashSet<TreeNode>();
	    while (!stack.isEmpty()) {
	        TreeNode cur = stack.pop();
	        if (visited.contains(cur))
	            ans.add(cur.val);
	        else {
	            stack.push(cur);
	            visited.add(cur);
	            if (cur.right != null) stack.push(cur.right);
	            if (cur.left != null) stack.push(cur.left);
	        }
	    }
	    return ans;
	}
}
