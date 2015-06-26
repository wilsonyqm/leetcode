package leetcode;
//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
import java.util.*;

public class EvalPRN {
	public int evalRPN(String[] tokens) {
	    if(tokens==null) return 0;
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<tokens.length;i++){
			char ch=tokens[i].charAt(0);
			if((ch>='0' && ch<='9') || tokens[i].length()>1){
				stack.push(Integer.parseInt(tokens[i]));
			}
			else if(ch=='+'){
				stack.push(stack.pop()+stack.pop());
			}
			else if(ch=='/'){
				int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
                //此处如果用一句话写会出错，Divide by 0， 可能是因为给int后有强制类型转换。
			}
			else if(ch=='*'){
				stack.push(stack.pop()*stack.pop());
			}
			else if(ch=='-'){
				stack.push(0-stack.pop()+stack.pop());
			}
		}
		return stack.pop();
	}
}
