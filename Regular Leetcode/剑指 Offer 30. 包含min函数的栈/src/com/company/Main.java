package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    class MinStack {

        Stack<Integer> stack, minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek())
                minStack.push(x);
        }

        public void pop() {
            int top = stack.pop();
            if (!minStack.isEmpty() && minStack.peek().equals(top))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
