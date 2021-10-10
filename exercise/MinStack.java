package exercise;

import java.util.Stack;

public class MinStack {
	private  Stack<Character> stack;
    private  Stack<Character> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(char x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        System.out.println(stack.pop() == minStack.peek());
        if(stack.pop() == minStack.peek()){
            minStack.pop();
        }
    }
    public char top() {
        if(stack.isEmpty()) return 0;
        return stack.peek();

    }
    
    public char getMin() {
        if(minStack.isEmpty()) return 9;
        return minStack.peek();
    }
    public static void main(String[] args) {
    	  MinStack obj = new MinStack();
    	  obj.push('s');
    	  obj.push('s');
    	  obj.push('s');
    	  obj.push('s');
    	  obj.pop();
    	  System.out.println(obj.getMin());
    	  obj.pop();
    	  System.out.println(obj.getMin());
    	  obj.pop();
    	  System.out.println(obj.getMin()); 	 
	}
}
