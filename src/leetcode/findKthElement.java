package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthElement {
	public double findKth(int A[],int m, int B[], int n, int k){
    	if(m<=0) return B[k-1];//-1 is for having to start with 1 with a_len
    	if(n<=0) return A[k-1];
    	if(k<=0) return Math.min(A[0],B[0]);//In fact we dont need this
    	if(A[m/2]<B[n/2]){
    		if(m/2+n/2+1>=k){//[1,2,2],[1,2,3] would be error if without equal,ArrayIndeoutofBound on line 19 if n=1,so n/2==0
    			return findKth(A,m,B,n/2,k);
    		}else{
    			return findKth(Arrays.copyOfRange(A, m/2+1, m),m-(m/2+1),B,n,k-(m/2+1));
    		}
    	}
    	else{
    		if(m/2+n/2+1>=k){
    			return findKth(A,m/2,B,n,k);
    		}else{
    			return findKth(A,m,Arrays.copyOfRange(B, n/2+1, n),n-(n/2+1),k-(n/2+1));
    		}
    	}
    }
	public int findKthHeap(int A[],int m,int B[],int n,int k){
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		for(int i=0;i<m;i++){
			q.offer(A[i]);
		}
		for(int j=0;j<n;j++){
			q.offer(B[j]);
		}
		int res;
		for(int ii=0;ii<k-1;ii++){
			q.poll();
		}
		res=q.poll();
		return res;
	}
	public static void main(String args[]){
		findKthElement test=new findKthElement();
		int[] A=new int[]{1,2,2,1,0,-1,-2};
		int[] B=new int[]{2,3,4};
		double res=test.findKth(A, A.length, B, B.length, 3);
		System.out.println("Kth: "+res);
		
		int res1=test.findKthHeap(A, A.length, B, B.length, 3);
		System.out.println("KthHeap: "+res1);
		
	}
}
