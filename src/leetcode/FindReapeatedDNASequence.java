package leetcode;
//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//For example,
//
//Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//Return:
//["AAAAACCCCC", "CCCCCAAAAA"].
import java.util.*;
public class FindReapeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<String>();
		if(s.length()<10) return res;
        HashSet<Integer> set1=new HashSet<>();
        HashSet<String> set2=new HashSet<>();
		for(int i=9;i<s.length();i++){
        		String sub=s.substring(i-9, i+1);
        		int code=decode(sub);
        		if(set1.contains(code)){
        			set2.add(sub);
        		}else{
        			set1.add(code);
        		}
        }
		res.addAll(set2);
		return res;
    }
	public int decode(String s){
		int sum=0;
		char[] ch=s.toCharArray();
		for(char c:ch){
			if(c=='A'){
				sum=sum*4;
			}
			else if(c=='C'){
				sum=sum*4+1;
			}
			else if(c=='G'){
				sum=sum*4+2;
			}
			else if(c=='T'){
				sum=sum*4+3;
			}
		}
		return sum;
	}
}
