package com.company;

import java.util.Stack;

public class Main {

    public int calc(int left, int right, String op) {
        switch (op) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
        }
        return 0;
    }

    public int isOP(String token) {
        switch (token) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> opStack = new Stack<>();
        for (String token : tokens) {
            int isop = isOP(token);
            if (isop < 0)
                numberStack.push(Integer.parseInt(token));
            else {
                int right = numberStack.pop(), left = numberStack.pop();
                numberStack.push(calc(left, right, token));
            }
        }
        return numberStack.pop();
    }

    public void work() {
        String[] tokens = {"10","7","+","3","/"};
        System.out.println(evalRPN(tokens));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
