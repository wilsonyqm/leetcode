package leetcode;
import java.util.*;
public class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> sol=new ArrayList<>();
        helper(root,res,sol,sum,0);
        return res;
    }
    public void helper(TreeNode root,List<List<Integer>> res, List<Integer> sol,int sum,int tmp){
        if(root==null) return;
        tmp+=root.val;
        if(root.left==null && root.right==null){//u have to be a leaf to compare the sum
            if(sum==tmp){//when compared u have to add the result and also remove the solution.
            //this means a small back-tracking
                sol.add(root.val);
                res.add(new ArrayList<Integer>(sol));
                sol.remove(sol.size()-1);
            }
            return;
        }
        //back-tracking with left and right, which is quite different from the backt
        sol.add(root.val);
        helper(root.left,res,sol,sum,tmp);
        helper(root.right,res,sol,sum,tmp);
        sol.remove(sol.size()-1);
    }
}
