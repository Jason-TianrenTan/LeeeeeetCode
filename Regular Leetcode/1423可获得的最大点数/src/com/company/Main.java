package com.company;

public class Main {

    public int maxScore(int[] cardPoints, int k) {
        int[] sum = new int[cardPoints.length + 1];
        sum[0] = 0;
        int min = -1, tlen = cardPoints.length - k, total_Sum = 0;
        for (int i=0;i<cardPoints.length;i++)
            sum[i + 1] = sum[i] + cardPoints[i];
        total_Sum = sum[cardPoints.length];
        for (int i=1;i<=cardPoints.length - tlen + 1;i++) {
            int points = sum[i + tlen - 1] - sum[i - 1];
            if (min < 0)
                min = points;
            else
                min = min < points? min : points;
        }
        return total_Sum - min;
    }

    public void work() {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
