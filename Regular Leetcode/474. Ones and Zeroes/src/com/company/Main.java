package com.company;

public class Main {

    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[][] f = new int[m + 1][n + 1];
        int[] oneCounts = new int[size + 1], zeroCounts = new int[size + 1];
        for (int i = 0; i < size; i++) {
            char[] arr = strs[i].toCharArray();
            for (char c : arr) {
                if (c == '0')
                    zeroCounts[i + 1]++;
                else oneCounts[i + 1]++;
            }
        }

        for (int k = 1; k <= size; k++) {
            System.out.println("str at " + strs[k - 1]);
            for (int i = m; i >= 1; i--) {
                for (int j = n; j >= 1; j--) {
                    System.out.println("---------i = " + i + ", j = " + j + "----------");


                    if (i >= zeroCounts[k] && j >= oneCounts[k] && f[i - zeroCounts[k]][j - oneCounts[k]] + 1 > f[i][j]) {
                        System.out.println("F[" + (i - zeroCounts[k]) + "][" + (j - oneCounts[k]) + "](" + f[i - zeroCounts[k]][j - oneCounts[k]] + ") + 1 > F[" + i + "][" + j + "] (" + f[i][j] + ")");
                        f[i][j] = f[i - zeroCounts[k]][j - oneCounts[k]] + 1;
                    }
                }
            }
        }
        return f[m][n];
    }


    public void work() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println("Ans = " + findMaxForm(strs, 4, 3));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
