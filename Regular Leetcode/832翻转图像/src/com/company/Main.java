package com.company;

public class Main {

    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length, k;
        if (n % 2 == 0)
            k = n / 2;
        else k = n / 2 + 1;
        int temp = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < k; j++) {
                temp = A[i][j];
                A[i][j] = 1 - A[i][n - 1 - j];
                A[i][n - 1 - j] = 1 - temp;
            }
        return A;
    }

    public void work() {
        int[][] A = {
                {1}
        };

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
