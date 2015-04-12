package leetcode;

public class ReverseInteger {
	public int reverse(int x){
		if(x==0) return x;
		int sign= (x>0)? 1:-1;
		x=Math.abs(x);
		int sum=0;
		while(x!=0){
			sum=sum*10+x%10;
			x=x/10;
		}
		return sign*sum;
	}
	public static void main(String args[]){
		ReverseInteger test =new ReverseInteger();
		System.out.println(test.reverse(-19920));
	}
}
