package leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int len=strs[0].length();
        for(int j=0;j<len;j++){
        	for(int i=0;i<strs.length;i++){
        		char c=strs[0].charAt(j);
        		if(strs[i].length()==j || strs[i].charAt(j)!=c) 
        			return strs[i].substring(0, j);
        	}
        }
        return strs[0];
    }
}
