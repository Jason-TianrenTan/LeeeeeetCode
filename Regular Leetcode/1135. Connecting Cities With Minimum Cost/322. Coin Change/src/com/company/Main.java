package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return -1;
        int n = coins.length;
        int[] f = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 0; i <= amount; i++)
            f[i] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] <= amount)
                f[coins[i]] = 1;
        }
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i && f[i - coins[j]] < f[i] - 1) {
                    f[i] = f[i - coins[j]] + 1;
                }
            }
        }

        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

    public void work() {
        int[] coins = {2};
        System.out.println(coinChange(coins, 1));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
