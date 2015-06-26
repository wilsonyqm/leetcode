package leetcode;
import java.util.*;
public class FractionToDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        if(denominator==0) return "";
        String result="";
        if(numerator<0 ^ denominator<0)
        		result+="-";
        long num=Math.abs(numerator);
        long den=Math.abs(denominator);
        long res=num / den;
        result+=String.valueOf(res);
        long remain=num % den*10;//需要提前进位
        if(remain==0)
        		return result;
        result+=".";
        HashMap<Long,Integer> map=new HashMap<>();
        while(remain!=0){
        		if(map.containsKey(remain)){
        			int pos=map.get(remain);
        			String str1=result.substring(0, pos);
        			String str2=result.substring(pos, result.length());
        			result=str1+"("+str2+")";
        			return result;
        		}
        		map.put(remain, result.length());
        		long tmp=remain/den;
        		result+=String.valueOf(tmp);
        		remain=remain%den*10;
        }
        return result;
    }
	public static void main(String args[]){
		FractionToDecimal test= new FractionToDecimal();
		System.out.println(test.fractionToDecimal(1, 3));
		
	}
}
