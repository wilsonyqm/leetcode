package leetcode;
import java.util.*;
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
    	List<String> res=new ArrayList<String>();
    	if(n==0){
    		return res;
    	}
    	helper(n,n,res,"");
    	return res;
    }
    public void helper(int left,int right,List<String> res,String s){
    	if(left==0 && right==0) {
    		res.add(s);
    		return;
    	}

    		if(left>0){//cannot assign s=s+"("; the way to do backtracking cannot revise the parameter, if revise, u have to delete
    			helper(left-1,right,res,s+"(");
    		}
    		if(right>left){
    			helper(left,right-1,res,s+")");
    		}
    		
    	
    }
    public static void main(String args[]){
    	GenerateParenthesis test=new GenerateParenthesis();
    	for(String s:test.generateParenthesis(3)){
    		System.out.println(s);
    	}
    }
}
