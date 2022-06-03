package com.company;

public class Main {

    /*
    121 I
     */
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        int[] f = new int[prices.length];
//        f[0] = prices[0];
//        for (int i=0;i<prices.length;i++)
//            f[i] = prices[i];
//        for (int i=1;i<prices.length;i++) {
//            f[i] = f[i] < f[i-1] ? f[i] : f[i-1];
//        }
//        for (int i=1;i<prices.length;i++) {
//            int profit = prices[i] - f[i];
//            max = profit > max ? profit : max;
//        }
//        return max;
//    }

    /*
    122 II
     */
//    public int maxProfit(int[] prices) {
//        int max = 0;
//
//        int[][] f = new int[prices.length][2];
//        f[0][0] = -prices[0];
//        //0:买完 1:卖完
//        for (int i=1;i<prices.length;i++) {
//            int max1 = 0, max0 = -10001;
//            for (int j=0;j<i;j++) {
//                max1 = max1 > f[j][1] ? max1 : f[j][1];
//                max0 = max0 > f[j][0] ? max0 : f[j][0];
//            }
//            f[i][0] = max1 - prices[i];
//            f[i][1] = max0 + prices[i];
//            max = max > f[i][1] ? max : f[i][1];
//        }
//        return max;
//    }

    /*
    123 III
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int[][] f = new int[prices.length][5];
        /*
        0:无操作
        1:第一次买入
        2:第一次卖出
        3:第二次买入
        4:第二次卖出
         */
        f[0][0]= 0;
        f[0][1] = -prices[0];
        f[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i]);
            f[i][2] = Math.max(f[i-1][2], f[i-1][1] + prices[i]);
            f[i][3] = Math.max(f[i-1][3], f[i-1][2] - prices[i]);
            f[i][4] = Math.max(f[i-1][4], f[i-1][3] + prices[i]);
        }
        return f[prices.length - 1][4];
    }

    /*
    188 IV
     */
    public int maxProfit(int K, int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][][] f = new int[prices.length][K + 1][3];
        for (int i=1;i<=K;i++)
            f[0][i][1] = -prices[0];
        for (int i=1;i<prices.length;i++) {
            for (int k=1;k<=K;k++) {
                f[i][k][1] = Math.max(f[i-1][k][1], f[i-1][k-1][2] - prices[i]);
                f[i][k][2] = Math.max(f[i-1][k][2], f[i-1][k][1] + prices[i]);
//                System.out.println("第" + (i + 1) + "天, 第" + k + "次买入 = " + f[i][k][1]);
//                System.out.println("第" + (i + 1) + "天，第" + k + "次卖出 = " + f[i][k][2]);
            }
        }
        return f[prices.length-1][K][2];
    }

    public void work() {
        int[] prices = {3,2,6,5,0,3,7,2,9};
        int k = 3;
        System.out.println(maxProfit(3, prices));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
