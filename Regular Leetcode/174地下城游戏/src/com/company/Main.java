package com.company;

public class Main {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] f = new int[m + 1][n + 1];
        for (int i=0;i<=m;i++)
            for (int j=0;j<=n;j++)
                f[i][j] = Integer.MAX_VALUE;
        f[m][n-1] = f[m-1][n] = 1;
        for (int i=m-1;i>=0;i--) {
            for (int j = n - 1; j >= 0; j--)
                f[i][j] = Math.max(1, Math.min(f[i + 1][j], f[i][j + 1]) - dungeon[i][j]);
        }
        return f[0][0];
    }

    public void work() {
        int[][] dungeon = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        System.out.println(calculateMinimumHP(dungeon));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
