package com.company;

public class Main {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] != matrix[row - 1][col - 1])
                    return false;
            }
        }
        return true;
    }

    public void work() {
        int[][] matrix = {
                {1}
        };

        System.out.println(isToeplitzMatrix(matrix));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
