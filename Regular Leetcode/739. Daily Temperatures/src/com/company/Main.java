package com.company;

import java.util.Stack;

public class Main {


    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> tStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!tStack.isEmpty() && t > temperatures[tStack.peek()]) {
                int initialDay = tStack.pop();
                result[initialDay] = i - initialDay;
            }
            tStack.push(i);
        }
        return result;
    }

    public void work() {
        int[] temperatures = {90, 30, 89};
        int[] res = dailyTemperatures(temperatures);
        for (int x : res)
            System.out.println(x);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
