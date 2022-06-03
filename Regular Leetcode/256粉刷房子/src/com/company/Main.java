package com.company;

public class Main {

    int min(int a, int b) {
        return a < b ? a : b;
    }

    public int minCost(int[][] costs) {
        if (costs.length == 0)
            return 0;
        int[][] f = new int[costs.length][3];
        for (int type=0;type<3;type++)
            f[0][type] = costs[0][type];
        for (int i=1;i<costs.length;i++) {
            f[i][0] = min(f[i-1][1], f[i-1][2]) + costs[i][0];
            f[i][1] = min(f[i-1][0], f[i-1][2]) + costs[i][1];
            f[i][2] = min(f[i-1][0], f[i-1][1]) + costs[i][2];
        }
        return min(f[costs.length-1][0], min(f[costs.length-1][1], f[costs.length-1][2]));
    }

    public void work() {
        int[][] costs = {{17,2,17},
                {16,16,5},
                {14,3,19}};
        System.out.println(minCost(costs));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
