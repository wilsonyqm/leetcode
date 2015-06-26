package leetcode;
import java.util.*;
public class MinStack {
	Stack<Integer> stack=new Stack<>();
    Stack<Integer> min=new Stack<>();
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek()>=x){
            min.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        int temp=stack.pop();
        if(temp==min.peek()) min.pop();
    }

    public int top() {
        if(stack.isEmpty()) return 0;
        return stack.peek();
    }

    public int getMin() {
        if(min.isEmpty()) return 0;
        return min.peek();
    }
    
    //main
    public static void main(String args[]){
    		MinStack test=new MinStack();
    		test.push(3);
    		test.push(2);
    		test.push(1);
    		System.out.println(test.getMin());
    		test.pop();
    		System.out.println(test.getMin());
    		test.pop();
    		System.out.println(test.getMin());
    		String version1="9.3";
    		String[] num1=version1.split("\\.");
    		for(String num:num1) {
    			System.out.println(num);
    		}
    		
    }
}
