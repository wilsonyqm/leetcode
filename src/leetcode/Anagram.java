package leetcode;
import java.util.*;
public class Anagram {
	public List<String> anagrams(String[] strs){
		List<String> result=new ArrayList<String>();
		if(strs.length==0) return result;
		HashMap<String,String> map=new HashMap<String,String>();
		for(String str:strs){
			char[] temp=str.toCharArray();
			Arrays.sort(temp);
			String sorted=new String(temp);
			if(map.containsKey(sorted)){
				if(!result.contains(map.get(sorted)))
					result.add(map.get(sorted));
				result.add(str);
			}else{
				map.put(sorted, str);
			}
		}
		return result;
	}
	public static void main(String args[]){
		Anagram test= new Anagram();
		List<String> result=new ArrayList<String>();
		String[] strs=new String[]{"ama","aam","bbc","cbb","fjroae","bbb"};
		result=test.anagrams(strs);
		for(String str:result){
			System.out.println(str+" ");
		}
		return;
	}
}
