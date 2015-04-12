package leetcode;
import java.util.*;
public class threeSum {
	public List<List<Integer>> threeSum1(int[] num) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(num.length==0) return res;
        int len=num.length;
        Arrays.sort(num);
        for(int i=0;i<len-2;i++){
        	if(i!=0 && num[i]==num[i-1]) continue;//i-1 compare with i is better
        	int j=i+1;
        	int k=len-1;
        	while(k>j){
        		if(num[i]+num[k]+num[j]==0){
        				ArrayList<Integer> temp=new ArrayList<Integer>();
        				temp.add(num[i]);
        				temp.add(num[j]);
        				temp.add(num[k]);
        				if(!res.contains(temp))//if only using this contains to get ride of duplicates, there would be TLE;
        					res.add(temp);
        				j++;
        		}
        		else if(num[i]+num[k]+num[j]<0){ 
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
		threeSum test=new threeSum();
		int[] sum=new int[]{-1,0,1,2,-1,-4};
		List<List<Integer>> auto=test.threeSum1(sum);
		for(List<Integer> t1:auto){
			for(int t2:t1){
				System.out.print(t2+" ");
			}
			System.out.println();
		}
	}
}
