package leetcode;
import java.util.*;
public class Permutation {
	public List<List<Integer>> permute(int[] num){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(num.length==0) return result;
		List<Integer> temp=new ArrayList<Integer>();
		helper(result,temp,num);
		return result;
	}
	public void helper(List<List<Integer>> res,List<Integer> temp,int[] num){
		if(temp.size()==num.length){
			res.add(new ArrayList<Integer>(temp));//this is quite necessary for immutation
			return;
		}
		for(int i=0;i<num.length;i++){
			if(temp.contains(num[i])) continue;
			temp.add(num[i]);
			helper(res,temp,num);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String args[]){
		Permutation test=new Permutation();
		int[] num=new int[] {1,2,3};
		List<List<Integer>> result=test.permute(num);
		for(List<Integer> res:result){
			for(int re:res){
				System.out.print(re+",");
			}
			System.out.print("  ");
		}
	}
}
