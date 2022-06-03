package com.company;

import java.util.HashMap;

public class Main {

    /*动态规划
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[][] f = new int[length][maxCost + 1];//f[i][j]:包含i在内花销为j的长度
        int[] cost = new int[length];
        for (int i=0;i<length;i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        for (int i=0;i<length;i++) {
            for (int j = 0; j <= maxCost; j++)
                f[i][j] = -1;
        }
        for (int i=0;i<length;i++)
            if (cost[i] <=maxCost)
                f[i][cost[i]] = 1;
        int max = 0;
        if (cost[0] <= maxCost)
            max = 1;
        for (int i=1;i<length;i++) {
            for (int j=0;j<=maxCost;j++) {
                if (j >= cost[i] && f[i-1][j-cost[i]]!= -1 && f[i-1][j - cost[i]] + 1 > f[i][j]) {
                    f[i][j] = f[i-1][j - cost[i]] + 1;
                }
                max = max > f[i][j] ? max : f[i][j];
            }
        }
        return max;
    }
     */

    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        //int[][] f = new int[length][maxCost + 1];//f[i][j]:包含i在内花销为j的长度
        int[] cost = new int[length + 1];
        for (int i=1;i<=length;i++) {
            cost[i] = Math.abs(s.charAt(i - 1) - t.charAt(i - 1));
        }

        int start = 1, end = 1;
        int max = 0;
        int _Cost = 0;
        while (end <= length) {
            _Cost += cost[end];
            while (start <= end && _Cost > maxCost) {
                _Cost -= cost[start];
                start++;
            }
            int len = end -start + 1;
            max = max > len ? max : len;
            end++;
        }
        return max;
    }

    public void work() {
        String s = "abcdaaaaa", t = "bcdeaaaaa";
        int maxCost = 1;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
