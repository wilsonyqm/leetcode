package leetcode;

import java.util.Arrays;


public class threeSumClosest {
	public int threeSum(int[] num,int target) {
        int len=num.length;
        Arrays.sort(num);
        int closest=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<len-2;i++){
        	if(i!=0 && num[i]==num[i-1]) continue;//i-1 compare with i is better
        	int j=i+1;
        	int k=len-1;
        	while(k>j){
        		if(closest>Math.abs(num[i]+num[k]+num[j]-target)){
        			closest=Math.abs(num[i]+num[k]+num[j]-target);
        			res=num[i]+num[k]+num[j];
        		}
        		else if(num[i]+num[k]+num[j]<target){ 
        			j++;
        			while(j<k && num[j]==num[j-1]) j++; 
        		}
        		else {
        			k--;
        			while(j<k && num[k]==num[k+1]) k--;
        		}
        	}
        }
        return res;
    }
	public static void main(String args[]){
		threeSumClosest test=new threeSumClosest();
		int[] sum=new int[]{-1,0,1,2,-1,-4};
		int auto=test.threeSum(sum,6);
		System.out.println(auto);
	}
}
