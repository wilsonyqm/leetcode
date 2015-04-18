package leetcode;

import java.util.*;

public class UniqueBST {
	public List<TreeNode> generateTrees(int n) {
        return generate(1,n);//has to start with 1!!,n
    }
	public ArrayList<TreeNode> generate(int start,int end){
		ArrayList<TreeNode> res=new ArrayList<TreeNode>();
		if(start>end){
			res.add(null);
			return res;
		}
		for(int i=start;i<=end;i++){//the equal sign here is for eliminating the i=end, i+1=end+1>start which lead to terminate.
			//since this start initial is 1 so, end has to be also equal
			ArrayList<TreeNode> left=generate(start,i-1);
			ArrayList<TreeNode> right=generate(i+1,end);
			for(TreeNode l:left){
				for(TreeNode r:right){
					TreeNode temp=new TreeNode(i);
					temp.left=l;
					temp.right=r;
					res.add(temp);
				}
			}
		}
		return res;
	}
}
