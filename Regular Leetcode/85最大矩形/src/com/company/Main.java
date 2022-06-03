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

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] rect = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '1') {
                    if (i == 0)
                        rect[i][j] = 1;
                    else
                        rect[i][j] = rect[i - 1][j] + 1;
                }
        }

        int ans = 0, area = 0;
        for (int i = 0; i < m; i++) {
            //逐行
            area = largestRectangleArea(rect[i]);
            ans = Math.max(ans, area);
        }
        return ans;
    }


    public void work() {
        char[][] matrix = {
                {'0','1','0'},
                {'1','1','1'},
                {'0','1','1'},
                {'0','1','1'}
        };
        System.out.println(maximalRectangle(matrix));
        
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
