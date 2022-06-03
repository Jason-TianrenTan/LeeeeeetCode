package com.company;

public class Main {

    public double largestSumOfAverages(int[] A, int K) {
        double[][] f = new double[A.length + 1][K + 1];
        double[] prefix_sum = new double[A.length +1];
        prefix_sum[0] = 0;
        f[1][1] = A[0];
        for (int i=1;i<=A.length;i++) {
            prefix_sum[i] = prefix_sum[i-1] + A[i - 1];
            f[i][1] = prefix_sum[i] / i;
        }
        for (int i=1;i<=A.length;i++) {
            for (int k=2;k<=K;k++) {
                if(k > i)
                    break;
                double max = -1;
                for (int j=1;j<i;j++) {
                    double aver_sum = f[j][k-1] + (double)(prefix_sum[i] - prefix_sum[j])/(i -j);
                    max = max > aver_sum ? max : aver_sum;
                }
                f[i][k] = max;
            }

        }
        return f[A.length][K];
    }

    public void work() {
        int[] A = {9,12,17};
        int K = 2;
        System.out.println(largestSumOfAverages(A, K));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
