package leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
        char[] arr=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        if(arr.length==0) return 0;
        int max=1;
        for(int i=0, j=0;j<arr.length;j++){
        	char c=arr[j];
        	if(!map.containsKey(c)){
        	}else{
        		i=Math.max(i, map.get(c)+1);
        		
        		//+1 is for move the char one ahead to get rid of the repeating character
        		//take the max is to avoid the inner repeating character like abba where bb is inner repeating
        	}
    		map.put(c, j);
        	max=Math.max(max,j-i+1);
        }
        return max;
    }
	public static void main(String args[]){
		String s="abba";
		LengthOfLongestSubstring test=new LengthOfLongestSubstring();
		System.out.println(test.lengthOfLongestSubstring(s));
	}
}
