package leetcode;

import java.util.Arrays;

public class findMedianTwoSortedArray {
    public double findMedianSortedArrays(int A[], int B[]) {
    	int a_len=A.length;
    	int b_len=B.length;
    	if((a_len+b_len)%2==0){
    		return (findMedian(A,a_len,B,b_len,(a_len+b_len)/2)+findMedian(A,a_len,B,b_len,(a_len+b_len)/2+1))/2;
    	}
    	else{
    		return findMedian(A,a_len,B,b_len,(a_len+b_len)/2+1);
    	}
    }
    
    public double findMedian(int A[],int m, int B[], int n, int k){
    	if(m<=0) return B[k-1];//-1 is for having to start with 1 with a_len
    	if(n<=0) return A[k-1];
    	if(k<=0) return Math.min(A[0],B[0]);//In fact we dont need this
    	if(A[m/2]<B[n/2]){
    		if(m/2+n/2+1>=k){//[1,2,2],[1,2,3] would be error if without equal,ArrayIndeoutofBound on line 19 if n=1,so n/2==0
    			return findMedian(A,m,B,n/2,k);
    		}else{
    			return findMedian(Arrays.copyOfRange(A, m/2+1, m),m-(m/2+1),B,n,k-(m/2+1));
    		}
    	}
    	else{
    		if(m/2+n/2+1>=k){
    			return findMedian(A,m/2,B,n,k);
    		}else{
    			return findMedian(A,m,Arrays.copyOfRange(B, n/2+1, n),n-(n/2+1),k-(n/2+1));
    		}
    	}
    	
    }
    
    //this method is wrong, since there is no k to record the length of rest array, so cannot easy find the median
    public double helper(int A[],int a_start, int a_end, int B[],int b_start,int b_end){
    	
    	int a_mid=a_start+(a_end-a_start)/2;
    	
    	int b_mid=b_start+(b_end-b_start)/2;
    	if(a_start+1>a_end) return B[b_end];
    	else if(b_start+1>b_end) return A[a_end];
    	if(A[a_mid]==B[b_mid]){
    		return A[a_mid];
    	}
    	else if(A[a_mid]<B[b_mid]){
    		return helper(A,a_start,a_end,B,b_start,b_mid);
    	}
    	else{
    		return helper(A,a_start,a_mid,B,b_start,b_end);
    	}
    }
    public static void main(String args[]){
    	findMedianTwoSortedArray test=new findMedianTwoSortedArray();
    	int[] A=new int[]{1,2,6,7};
    	int[] B=new int[]{3,4,8,9,10,11,12,13,14,15,16,17};
    	double res=test.findMedianSortedArrays(A, B);
    	System.out.println("The Median is: "+res);
    }
}
