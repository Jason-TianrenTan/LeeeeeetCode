package com.company;

public class Main {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m][n];
        int maxSize = 0;
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++) {
                if (matrix[i][j] == '1') {
                    f[i][j] = 1;
                    maxSize = 1;
                }
            }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][j] == '1') {
                    f[i][j] = Math.min(f[i-1][j-1], Math.min(f[i-1][j], f[i][j-1])) + 1;
                    maxSize = Math.max(maxSize, f[i][j]);
                }
            }
        }
        return maxSize * maxSize;
    }

    public void work() {

        char[][] matrix = {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };

        System.out.println(maximalSquare(matrix));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
