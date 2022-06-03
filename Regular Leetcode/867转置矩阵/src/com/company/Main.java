package com.company;

public class Main {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        return ans;
    }

    public void work() {

        int[][] matrix0 = {
                {1}
        };
        int[][] matrix = transpose(matrix0);
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
