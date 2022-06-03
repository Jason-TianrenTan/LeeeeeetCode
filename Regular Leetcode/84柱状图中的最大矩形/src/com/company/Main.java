package com.company;

import java.util.Stack;

public class Main {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || heights[i] >= heights[stack.peek()])
                stack.add(i);
            else {
                while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                    int height = heights[stack.peek()];
                    stack.pop();
                    int start = -1;
                    if (!stack.empty())
                        start = stack.peek();
                    int area = (i - start - 1) * height;
                    ans = Math.max(area, ans);
                }
                stack.add(i);
            }
        }
        while (!stack.empty()) {
            int index = stack.peek();
            int start = -1;
            stack.pop();
            if (!stack.empty())
                start = stack.peek();
            int area = heights[index] * (heights.length - start - 1);
            ans = Math.max(area, ans);
        }
        return ans;
    }

    public void work() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
