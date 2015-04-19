package leetcode;

import java.util.Arrays;

public class Candy {
	public int candy(int[] ratings){
		int len=ratings.length;
		if(len==0) return 0;
		int res=0;
		int[] sum=new int[len];
		Arrays.fill(sum, 1);
		for(int i=1;i<len;i++){
			if(ratings[i-1]<ratings[i])
				sum[i]=sum[i-1]+1;
		}
		for(int j=len-1;j>=1;j--){
			res+=sum[j];
			if(ratings[j-1]>ratings[j] && sum[j-1]<=sum[j]){
				sum[j-1]=sum[j]+1;
			}
		}
		return sum[0]+res;
	}
}
