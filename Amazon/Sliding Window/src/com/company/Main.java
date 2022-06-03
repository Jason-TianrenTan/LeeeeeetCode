package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public void work() {
        int[] arr = {1, 2, 7, 7, 4, 3, 6};
        int k = 3;
        Map<Integer, Integer> countMap = new HashMap<>();
        int st = 0;
        int[] sum = new int[arr.length + 1];
        int max = -1;
        for (int ed = 0; ed < arr.length; ed++) {
            sum[ed + 1] = sum[ed] + arr[ed];
            countMap.put(arr[ed], countMap.getOrDefault(arr[ed], 0) + 1);
            while (st <= ed && countMap.get(arr[ed]) > 1) {
                countMap.put(arr[st], countMap.get(arr[st]) - 1);
                st++;
                if (countMap.get(arr[st]) == 0)
                    countMap.remove(arr[st]);
            }
            if (ed - st + 1 == k) {
                max = Math.max(max, sum[ed + 1] - sum[st]);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
