package com.company;

public class Main {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0Mark = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0Mark = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = m - 1; i > 0; i--) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++)
                    matrix[i][j] = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++)
                    matrix[i][j] = 0;
            }
        }

        if (row0Mark) {
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
    }

    public void work() {
        int[][] matrix = {
                {-4,-2147483648,6,-7,0},
                {-8,6,-8,-6,0},
                {2147483647,2,-9,-6,-10}
        };
        setZeroes(matrix);
        for (int i=0;i<matrix.length;i++) {
            for (int x : matrix[i])
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
