package leetcode;

public class ReverseWordInString {
	public String reverseWords(String s) {
		if(s.length()==0) return s;
		int len=s.length()-1;
		StringBuilder ans=new StringBuilder();
		while(len>=0){
			while(len>=0 && s.charAt(len)==' ') len--;
			if(len==-1) break;
			StringBuilder sb=new StringBuilder();
			while(len>=0 && s.charAt(len)!=' '){
				sb.append(s.charAt(len--));
			}
			if(ans.length()==0){
				ans.append(sb.reverse().toString());
			}
			else{
				ans.append(" "+sb.reverse().toString());
			}
		}
		return ans.toString();
	}
	public static void main(String args[]){
		String s=" the sky is blue " ;
		ReverseWordInString test=new ReverseWordInString();
		System.out.println(test.reverseWords(s));
	}
}
