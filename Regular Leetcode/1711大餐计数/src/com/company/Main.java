package com.company;

import java.util.*;
import java.util.HashMap;

public class Main {

    static int MOD = 1000000007;
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> tasteMap = new HashMap<>();
        int maxVal = -1;
        for (int d : deliciousness)
            maxVal = maxVal > d ? maxVal : d;
        int ans = 0;
        int maxSum = 2 * maxVal;
        for (int delicious : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                ans += tasteMap.getOrDefault(sum - delicious, 0);
                ans %= MOD;
            }
            tasteMap.put(delicious, tasteMap.getOrDefault(delicious, 0) + 1);
        }
        return ans;
    }

    public void work() {
        int[] deliciousness = {1,1,1,3,3,3,7};
        System.out.println(countPairs(deliciousness));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
