package leetcode;

public class StringToInteger_atoi {
	public int atoi(String str) {
        char[] arr=str.toCharArray();
        int i=0;
        int sign=1;
        int len=arr.length;
        while(i<len && Character.isWhitespace(arr[i])) i++;
        if(i<len && arr[i]=='-') {
        	sign=-1;
        	i++;
        }
        else if(i<len && arr[i]=='+') i++;
        int sum=0;
        int max=Integer.MAX_VALUE/10;
        while(i<len && Character.isDigit(arr[i])){
        	int c=Character.getNumericValue(arr[i]);
        	if(sum>max || (sum==max && c>=8)){
        			return (sign==1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
        		}
        		else{
        			sum=sum*10+c;
        		}
        	
        	i++;
        }
        return sum*sign;
    }
	public static void main(String args[]){
		StringToInteger_atoi test=new StringToInteger_atoi();
		String s="  -2147483649";
		System.out.println(test.atoi(s));
				
	}
}
