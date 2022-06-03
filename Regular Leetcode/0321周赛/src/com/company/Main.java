package com.company;

import java.util.*;

public class Main {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        //[0, x] -> [y, y+x]
        //y <= x + 1
        int x = 0;
        for (int y : coins) {
            if (y > x + 1)
                break;
            x += y;
        }
        return x + 1;
    }

    public void work() {
        int[] coins = {1,4,10,3,1};
        System.out.println(getMaximumConsecutive(coins));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
