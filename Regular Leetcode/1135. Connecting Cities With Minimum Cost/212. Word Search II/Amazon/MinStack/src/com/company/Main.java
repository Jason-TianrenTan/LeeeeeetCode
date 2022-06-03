package com.company;

import java.util.Stack;

public class Main {

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> min;
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (min.isEmpty() || val <= min.peek())
                min.add(val);
        }

        public void pop() {
            if (stack.pop().intValue() == min.peek().intValue())
                min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
