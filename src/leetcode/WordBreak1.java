package leetcode;
import java.util.*;
public class WordBreak1 {
//	Given a string s and a dictionary of words dict, 
	//determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//	For example, given
//	s = "leetcode",
//	dict = ["leet", "code"].
//
//	Return true because "leetcode" can be segmented as "leet code".
	
	//the brute force method
	public boolean wordBreak1(String s, Set<String> dict) {
		return helper1(s,dict,0);
    }
	public boolean helper1(String s,Set<String> dict, int start){
		int len=s.length();
		if(start==len) return true;
		for(String str:dict){
			if(str.length()+start>len) 
				continue;
			if(s.substring(start, start+str.length()).equals(str)){
				if (helper1(s,dict,start+str.length())) 
					return true;
			}
		}
		return false;
	}
	
	public boolean wordBreak(String s,Set<String> dict){
		boolean[] status=new boolean[s.length()+1];//has to include a initial state
		status[0]=true;
		for(int i=1;i<=s.length();i++){//start with 1 and end with len
			for(int j=0;j<i;j++){
				if(status[j] && dict.contains(s.substring(j, i))){
					status[i]=true;//set i to be true, then break to continue word break
					break;
				}
			}
		}
		return status[s.length()];
	}
}
