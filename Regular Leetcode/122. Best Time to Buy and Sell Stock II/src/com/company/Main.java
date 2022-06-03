package com.company;

public class Main {

    public int maxProfit(int[] prices) {
        /**
         * 0: hold
         * 1: buy
         * 2: sell
         */
        int n = prices.length;
        int[][][] profit = new int[n][2][3];
        profit[0][0][1] = -prices[0];
        profit[0][1][0] = Integer.MIN_VALUE;
        for (int i=0;i<n;i++)
            profit[i][0][2] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            profit[i][1][2] = Math.max(profit[i - 1][1][0], profit[i - 1][0][1]) + prices[i];
            profit[i][0][1] = Math.max(profit[i - 1][0][0], profit[i - 1][1][2]) - prices[i];
            profit[i][0][0] = Math.max(Math.max(profit[i - 1][0][1], profit[i - 1][1][2]), profit[i-1][0][0]);
            profit[i][1][0] = Math.max(profit[i-1][1][0], profit[i-1][0][1]);
            System.out.println("On day " + i + ", buy = " + profit[i][0][1] + ", sell = " + profit[i][1][2] + ", hold = " + profit[i][0][0] + ", " + profit[i][1][0]);
        }
        int maxProfit = 0;
        for (int i = 0; i < 3; i++)
            for (int j=0;j<2;j++)
            maxProfit = Math.max(maxProfit, profit[n - 1][j][i]);
        return maxProfit;
    }

    public void work() {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
