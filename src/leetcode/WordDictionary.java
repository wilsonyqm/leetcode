package leetcode;
import java.util.*;
public class WordDictionary {
	public class TrieNode{
        char c;
        boolean isLeaf=false;
        HashMap<Character,TrieNode> map=new HashMap<>();
        TrieNode(char c){
            this.c=c;
        }
        TrieNode(){}
    }
	TrieNode root;
	TrieNode head;
    public WordDictionary(){
        root=new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] wordArray=word.toCharArray();
        head=root;
        for(char ch:wordArray){
            if(head.map.containsKey(ch)){
                head=head.map.get(ch);
            }
            else{
            		TrieNode tmp=new TrieNode(ch);
            		head.map.put(ch,tmp);
            		head=tmp;
            }
        }
        head.isLeaf=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word){
    		char[] wordArray=word.toCharArray();
    		head=root;
        return search(wordArray,head,0);
    }
    public boolean search(char[] wordArray,TrieNode head,int j) {
        if(j==wordArray.length) return head.isLeaf;
        		char ch=wordArray[j];
        		if(ch=='.'){
        			if(head.map.isEmpty()) return false;
        			for(char c:head.map.keySet()){
        				boolean b=search(wordArray,head.map.get(c),j+1);
        				if(b) return true;
        			}
        		}
        		else{
        			boolean b1=head.map.containsKey(ch);
        			if(!b1) return b1;
        			boolean b2=search(wordArray,head.map.get(ch),j+1);
        			return b1 && b2;
        		}
        return head.isLeaf;
    }
    public static void main(String args[]){
    		WordDictionary test=new WordDictionary();
    		test.addWord("at");
    		test.addWord("and");
    		test.addWord("an");
    		test.addWord("add");
    		test.search("a");
    		test.search(".at");
    		test.addWord("bat");
    		System.out.println(test.search(".at"));
    		System.out.println(test.search("an."));
    		System.out.println(test.search("a.d."));
    		System.out.println(test.search("b."));
    		System.out.println(test.search("a.d"));
    		System.out.println(test.search("."));
    		
    		int[] a=new int[1];
    		a[0]=1;
    		int[] b=a;
    		b[0]=2;
    		System.out.println(a[0]);
    		
    }
}
