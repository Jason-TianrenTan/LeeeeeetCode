package com.company;

public class Main {

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] trans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                trans[j][i] = matrix[i][j];
        }
        return trans;
    }

}
