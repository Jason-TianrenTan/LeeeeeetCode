package com.company;

public class Main {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] buy = new int[k], sell = new int[k];
        for (int b : buy)
            b = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }
        return sell[k - 1];
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
