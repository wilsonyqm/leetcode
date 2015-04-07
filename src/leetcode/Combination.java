package leetcode;
import java.util.*;
public class Combination {
	public List<List<Integer>> combine(int n,int k){
		List<List<Integer>> result= new ArrayList<List<Integer>>();
		if(n==0||k==0) return result;
		List<Integer> temp=new ArrayList<Integer>();
		helper(0,n,k,temp,result);
		return result;
	}
	private void helper(int j,int n,int k,List<Integer> temp,List<List<Integer>> result){
		if(temp.size()==k){
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=1;i<=n;i++){
			if(i<=j) continue;
			temp.add(i);
			helper(i,n,k,temp,result);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String args[]){
		Combination test=new Combination();
		List<List<Integer>> res=test.combine(4, 2);
		for(List<Integer> t1:res){
			for(Object t2:t1){
				System.out.print(t2+" ");
			}
			System.out.print("  ");
		}
	}
}
