package leetcode;
import java.util.*;
public class ImplementTrie {
	static class TrieNode {
	    // Initialize your data structure here.
	    char c;
	    HashMap<Character,TrieNode> map=new HashMap<>();
		public TrieNode() {}
	    public TrieNode(char c){
	    		this.c=c;
	    }
	}

	static public class Trie {
	    private TrieNode root;
	    private TrieNode head;
	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	    		head=root;
	        char[] wordArr=word.toCharArray();
	        for(char c:wordArr){
	        		if(head.map.containsKey(c)){
	        			head=head.map.get(c);
	        		}
	        		else{
	        			TrieNode tmp=new TrieNode(c);
	        			head.map.put(c, tmp);
	        			head=tmp;
	        		}
	        }
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    		head=root;
	        char[] wordArr=word.toCharArray();
		    for(char c:wordArr){
	        		if(head.map.containsKey(c)){
	        			head=head.map.get(c);
	        		}
	        		else{
	        			return false;
	        		}
	        }
		    return head.map.size()==0;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    		head=root;
	    		char[] wordArr=prefix.toCharArray();
		    for(char c:wordArr){
	        		if(head.map.containsKey(c)){
	        			head=head.map.get(c);
	        		}
	        		else{
	        			return false;
	        		}
	        }
		    return true;
	    }
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
	
	public static void main(String args[]){
		Trie trie=new Trie();
		trie.insert("something");
		System.out.println(trie.startsWith("some"));
		
	}
}
