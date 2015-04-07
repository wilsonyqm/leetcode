package leetcode;

public class Fibonacci1 {
	public int recursion(int n){
		if(n<=1) return n;
		if(n==2) return 1;
		return recursion(n-1)+recursion(n-2);
	}
	public int dp(int n){
		if(n<=1) return n;
		if(n==2) return 1;
		int[] arr=new int[n+1];
		arr[1]=1;
		arr[2]=1;
		for(int i=3;i<n+1;i++){
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[n];
	}
	public static void main(String[] args){
		Fibonacci1 fb= new Fibonacci1();
		int n=10;
		int res1=fb.dp(n);
		System.out.println("First Test: "+res1);
		int res2=fb.recursion(n);
		System.out.println("Second Test: "+res2);
	}
}
