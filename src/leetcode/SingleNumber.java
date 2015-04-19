package leetcode;

public class SingleNumber {
	public int singleNumber(int[] A) {
        int num=0;
        for(int i=0;i<A.length;i++){
            num^=A[i];
        }
        return num;
    }
//	For eg : A = [ 2, 3, 3, 3]
//			We count the number of 1s for each bit position. Then find mod 3 of each of them. The bit positions having mod 3  equal to one are the bits that are set due to the number occurring once.
//			Writing the Binary Representation of the numbers.
//			                                                                  0 0 1 0
//			                                                                  0 0 1 1
//			                                                                  0 0 1 1
//			                                                                  0 0 1 1
//			                                                                   —————-
//			We count the number of 1s for each bit ->                         0 0 4 3
//			Taking modulo 3 we get                                            0 0 1 0
//			and that’s our answer. -> 2
	public int singleNumber2(int[] A) {
        int count,result=0;
        for(int i=0;i<32;i++){
            count=0;
            for(int a:A){
                count+=(a & 1<<i)==0 ? 0:1;
            }
            if(count%3!=0){
                result |= (1<<i);
            }
        }
        return result;
    }
}
