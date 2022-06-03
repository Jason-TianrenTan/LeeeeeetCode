package com.company;

import java.util.Arrays;

public class Main {

    public int uniquePaths(int m, int n) {
        int f[][] = new int[m][n];
        Arrays.fill(f[0], 1);
        for (int i=0;i<m;i++)
            f[i][0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0)
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        return f[m - 1][n - 1];
    }

    public void work() {
        System.out.println(uniquePaths(1, 2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
