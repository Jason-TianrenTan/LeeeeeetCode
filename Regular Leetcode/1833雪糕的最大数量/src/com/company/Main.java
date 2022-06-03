package com.company;

import java.util.Arrays;

public class Main {

    public int maxIceCream(int[] costs, int coins) {
        int res = 0, current = 0;
        int i = 0;
        Arrays.sort(costs);
        while (i < costs.length && (current + costs[i] <= coins)) {
                current += costs[i];
                i++;
                res++;
        }
        return res;
    }

    public void work() {
        int[] costs = {1,6,3,1,2,5};
        int coins = 20;
        System.out.println(maxIceCream(costs, coins));
    }
        
    public static void main(String[] args) {
        new Main().work();
    }
}
