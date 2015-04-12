package leetcode;

public class ReverseInteger {
	public int reverse(int x){
		if(x==0) return x;
		int sign= (x>0)? 1:-1;
		x=Math.abs(x);
		int sum=0;
		while(x!=0){
			//overflow
			if(sum>Integer.MAX_VALUE/10) return 0;
			sum=sum*10+x%10;
			x=x/10;
		}
		// two things to note:
		//1. we dont need to use the sign for this, since its already been taken care of.
		//2. we need to consider the overflow problem.
		return sign*sum;
	}
	public static void main(String args[]){
		ReverseInteger test =new ReverseInteger();
		System.out.println(test.reverse(-19920));
	}
}
