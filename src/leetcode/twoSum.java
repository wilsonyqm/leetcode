package leetcode;
import java.util.*;
public class twoSum {
	
	public  ArrayList<ArrayList<Integer>> twoSumMethod(int[] num,int target){
		HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		int len=num.length;
		for(int i=0;i<len;i++){
				if(mp.containsKey(num[i])){
					mp.put(num[i], mp.get(num[i])+1);
				}else{
					mp.put(num[i], 1);
				}
			}
		//System.out.println(mp.get(4));
		for(int i=0;i<len;i++){
			if(num[i]<=target/2){
				if(mp.containsKey(target-num[i])){
					ArrayList<Integer> temp=new ArrayList<Integer>();
					temp.add(num[i]);
					temp.add(target-num[i]);
					for(int j=0;j<mp.get(target-num[i]);j++){
						res.add(temp);
						//System.out.println(j+" "+num[i]);
					}
				}
			}
		}
		return res;
		}
	public static void main(String args[]){
		int[] test=new int[]{2,2,3,4,4,5,6,7,9,9,10};
		int target=11;
		twoSum twosum=new twoSum();
		ArrayList<ArrayList<Integer>> result=twosum.twoSumMethod(test,target);
		for(ArrayList<Integer> l1:result){
			System.out.print("{");
			for(Integer l2:l1){
				System.out.print(l2+" ");
			}
			System.out.println("}");
		}
	}
}
