package leetcode;
import java.util.*;
public class ValidParenthesis {
	public boolean isValid(String s) {
		if(s.length()==0) return false;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c=='['||c=='{'||c=='('){
				stack.push(c);
			}
			else{
				if(stack.isEmpty() || c-stack.pop()>2)//base case here is the stack is empty for ]
					return false;
			}
		}
		return stack.isEmpty(); //for case [
    }
	public static void main(String args[]){
		ValidParenthesis test=new ValidParenthesis();
		String s="[()]{[]}";
		System.out.println(test.isValid(s));
	}
}
