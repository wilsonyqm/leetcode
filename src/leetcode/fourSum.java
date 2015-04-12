package leetcode;
import java.util.*;
public class fourSum {
	public List<List<Integer>> fourSum1(int[] num,int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(num.length==0) return res;
        int len=num.length;
        Arrays.sort(num);
        for(int n=0;n<len-3;n++){
        	if(n!=0 && num[n]==num[n-1]) continue;//i-1 compare with i is better
        	
	        for(int i=n+1;i<len-2;i++){
	        	if(i!=n+1 && num[i]==num[i-1]) continue;//i!=n+1 which means cannot equals the first element for case {0 0 0 0}
	        	int j=i+1;
	        	int k=len-1;
	        	while(k>j){
	        		if(num[n]+num[i]+num[k]+num[j]==target){
	        				ArrayList<Integer> temp=new ArrayList<Integer>();
	        				temp.add(num[n]);
	        				temp.add(num[i]);
	        				temp.add(num[j]);
	        				temp.add(num[k]);
	        				if(!res.contains(temp))//if only using this contains to get ride of duplicates, there would be TLE;
	        					res.add(temp);
	        				j++;
	        		}
	        		else if(num[n]+num[i]+num[k]+num[j]<target){ 
	        			j++;
	        			while(j<k && num[j]==num[j-1]) j++; 
	        		}
	        		else {
	        			k--;
	        			while(j<k && num[k]==num[k+1]) k--;
	        		}
	        	}
	        }
        }
        return res;
    } 
	public static void main(String args[]){
		fourSum test=new fourSum();
		int[] sum=new int[]{-1,0,1,2,-1,-2};
		List<List<Integer>> auto=test.fourSum1(sum,0);
		for(List<Integer> t1:auto){
			for(int t2:t1){
				System.out.print(t2+" ");
			}
			System.out.println();
		}
	}
}
