package leetcode;

public class countPrimes {
	public int countPrime(int n){
		boolean[] isPrime=new boolean[n];
		for(int i=0;i<n;i++){
			isPrime[i]=true;
		}
		for(int i=2;i*i < n;i++){
			if(isPrime[i]==false) continue;
			for(int j=i*i;j<n;j+=i){
				isPrime[j]=false;
			}
		}
		int count=0;
		for(int i=0;i<n;i++){
			if(isPrime[i]) count++;
		}
		return count;
	}
}
