package leetcode;

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){this.val=x;}
	//insertion for test case only
	public boolean insert1(int element){
	    if(this.val == element){
	        return false;
	    }
	    TreeNode runner = this;
	    
	        if(runner.val > element){
	        	if(runner.left==null) runner.left=new TreeNode(element);
	        	else
	        		return runner.left.insert1(element);
	        } else if(runner.val < element){
	        	if(runner.right==null) runner.right=new TreeNode(element);
	        	else
	        	return runner.right.insert1(element);
	        }
	    return false;
	}
}