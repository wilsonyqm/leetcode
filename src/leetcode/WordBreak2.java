package leetcode;
import java.util.*;
//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//
//A solution is ["cats and dog", "cat sand dog"].
public class WordBreak2 {
	public List<String> wordBreak(String s,Set<String> dict){
		List<String> res=new ArrayList<String>();
		if(s==null || dict==null || !canBreak(s,dict)) 
			return res;
		helper(res,s,"",0,dict);
		return res;
	}
	public void helper(List<String> res,String s, String str, int i, Set<String> dict){
		int len=s.length();
		if(len==i){
			res.add(str.substring(1));
		}
		for(int j=i;j<len;j++){
			String sub=s.substring(i,j+1);//important to take care what is in substring with j+1 instead of j;
			if(dict.contains(sub)){
				helper(res,s,str+" "+sub,j+1,dict);
			}				
		}
	}
	public boolean canBreak(String s,Set<String> dict){
		boolean[] status=new boolean[s.length()+1];//has to include a initial state
		status[0]=true;
		for(int i=1;i<=s.length();i++){//start with 1 and end with len
			for(int j=0;j<s.length();j++){
				if(status[j] && dict.contains(s.substring(j, i))){
					status[i]=true;//set i to be true, then break to continue word break
					break;
				}
			}
		}
		return status[s.length()];
	}
}
