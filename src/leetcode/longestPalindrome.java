package leetcode;

public class longestPalindrome {
	public String longestPalindrome1(String s) {
        String max="";
        String temp;
		for(int i=0;i<s.length();i++){
			String left=searchpivot(s,i,i);
			
			String right=searchpivot(s,i,i+1);
			System.out.println(left+" "+right);
			temp=(left.length()>=right.length())? left:right;
			max=(temp.length()>=max.length())? temp:max;
        }
		return max;
    }
	public String searchpivot(String s,int i,int j){
		if(i<0||j>=s.length()) return "";
		char[] arr=s.toCharArray();
        if(arr.length==0) return "";
        while(arr[i]==arr[j]){
        	i--;
        	j++;//cannot be inside of the condition, cause the return would change 
        	if(i<0 || j>=arr.length){
        		return s.substring(i+1, j);
        	}
        }
        return s.substring(i+1, j);
	}
	public static void main(String args[]){
		longestPalindrome test= new longestPalindrome();
		String s="abb";
		System.out.println(s);
		System.out.println(test.longestPalindrome1(s));
	}
}
