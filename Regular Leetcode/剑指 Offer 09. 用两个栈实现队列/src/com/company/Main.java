package com.company;

import java.util.Stack;

public class Main {

    class CQueue {

        Stack<Integer> stack1, stack2;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty())
                return stack2.pop();
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

    public void work() {
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
