package leetcode;
import java.util.*;
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
		if(candidates.length==0) return res;
		Arrays.sort(candidates);
		helper(candidates,target,res,new ArrayList<Integer>(),0,0);
		return res;
    }
	public void helper(int[] candidates,int target,List<List<Integer>> res,List<Integer> temp,int sum,int j){
		if(sum==target){
			res.add(new ArrayList<Integer>(temp));
		}
		else if(sum>target) return;
		
		for(int i=j;i<candidates.length;i++){
			temp.add(candidates[i]);
			helper(candidates,target,res,temp,sum+candidates[i],i);
			temp.remove(temp.size()-1);
		}
	}
	
	//combination sum 2
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
		if(candidates.length==0) return res;
		Arrays.sort(candidates);
		helper2(candidates,target,res,new ArrayList<Integer>(),0,0);
		return res;
    }
	public void helper2(int[] candidates,int target,List<List<Integer>> res,List<Integer> temp,int sum,int j){
		if(sum==target){
			res.add(new ArrayList<Integer>(temp));
		}
		else if(sum>target || j>=candidates.length) return;
		int prev=-1;//DP method to remove the duplicates;[1,1] 1 case, the duplicate 1 is not allowed.
		for(int i=j;i<candidates.length;i++){
			if(prev==candidates[i]) continue;
			temp.add(candidates[i]);
			helper2(candidates,target,res,temp,sum+candidates[i],i+1);
			// i+1 here is better to modify j->j+1, since it consider the base case;
			prev=candidates[i];
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String args[]){
		CombinationSum test= new CombinationSum();
		int[] candidates=new int[]{2,3,6,7};
		for(List<Integer> i1:test.combinationSum(candidates, 7)){
			for(int i2:i1){
				System.out.print(i2+" ");
			}
			System.out.println();
		}
	}
}
