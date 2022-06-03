package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= max; i++) {
            for (int j = 2 * i; j <= max; j += i) {
                cnt.put(i, cnt.getOrDefault(i, 0) + cnt.getOrDefault(j, 0));
            }
        }
        long ans = 0;
        for (int num : nums) {
            ans += cnt.getOrDefault(k / gcd(num, k), 0);
            long product = num * num;
            if (product % k == 0)
                ans--;
        }
        System.out.println(ans);
        return ans / 2;
    }

    public void work() {
        int[] nums = {1, 2, 3 ,4 ,5};
        System.out.println(countPairs(nums, 2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
