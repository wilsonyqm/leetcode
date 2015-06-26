package leetcode;

public class isPrime {
	 public boolean isPrimeNum(int num) {
        if (num % 2 == 0)
            return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
  }  
}
