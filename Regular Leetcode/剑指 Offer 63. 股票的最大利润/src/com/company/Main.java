package com.company;

import java.util.Stack;

public class Main {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];
        /**
         * 0 sell
         * 1 buy
         */
        for (int i=0;i<n;i++)
            f[i][1] = -prices[i];

        for (int i=1;i<n;i++) {
            f[i][0] = Math.max(f[i - 1][1] + prices[i], f[i - 1][0]);
            f[i][1] = Math.max(f[i - 1][0] - prices[i], f[i - 1][1]);
        }

        return f[n - 1][0];
    }

    /**
     * 122
    public int maxProfit(int[] prices) {
        //greedy
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
     */

    /**
     * 121
     * public int maxProfit(int[] prices) {
     * int maxProfit = 0, minPrice = Integer.MAX_VALUE;
     * for (int p : prices) {
     * if (p < minPrice)
     * minPrice = p;
     * else if (p - minPrice > maxProfit)
     * maxProfit = p - minPrice;
     * }
     * return maxProfit;
     * }
     */


    public void work() {
        int[] prices = {7, 2, 5, 3, 6, 4, 1, 8};
        System.out.println(maxProfit(prices));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
