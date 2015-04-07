package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuationDuplicates {
	public List<List<Integer>> permuteUnique(int[] num){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(num.length==0) return result;
		List<Integer> temp=new ArrayList<Integer>();
		int[] visited=new int[num.length];
		Arrays.sort(num);
		helper(result,temp,visited,num);
		return result;
	}
	public void helper(List<List<Integer>> res,List<Integer> temp,int[] visited,int[] num){
		if(temp.size()==num.length){
			res.add(new ArrayList<Integer>(temp));//this is quite necessary for immutation
			return;
		}
		for(int i=0;i<num.length;i++){
			//cannot skip the duplicates and do the recursion, for example, cannot start from the second duplicates and do permuation
			//which will generate duplicate permutation
			if(visited[i]==1 || (i>0 && num[i]==num[i-1] && visited[i-1]==0)) continue;
			visited[i]=1;
			temp.add(num[i]);
			helper(res,temp,visited,num);
			temp.remove(temp.size()-1);
			visited[i]=0;
		}
	}
	public static void main(String args[]){
		PermuationDuplicates test=new PermuationDuplicates();
		int[] num=new int[] {1,2,2};
		List<List<Integer>> result=test.permuteUnique(num);
		for(List<Integer> res:result){
			for(int re:res){
				System.out.print(re+",");
			}
			System.out.print("  ");
		}
	}
}
