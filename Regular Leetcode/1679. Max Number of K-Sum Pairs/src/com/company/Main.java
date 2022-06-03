package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        int operations = 0;
        if (k % 2 == 0)
            operations = freq.getOrDefault(k / 2, 0) / 2;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int x = entry.getKey(), count = entry.getValue();
            if (x * 2 != k)
                operations += Math.min(count, freq.getOrDefault(k - x, 0));
        }
        return operations / 2;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
