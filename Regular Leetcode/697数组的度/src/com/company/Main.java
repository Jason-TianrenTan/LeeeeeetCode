package com.company;

import java.util.HashMap;

public class Main {

    public int findShortestSubArray(int[] nums) {
        int minLen = 1;
        int T = 1;//Target
        HashMap<Integer, Integer> cnt = new HashMap<>();
        HashMap<Integer, Integer> start = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int x = nums[i];
            if (!start.containsKey(x))
                start.put(x, i);
            int count = cnt.getOrDefault(x, -1);
            if (count < 0)
                cnt.put(x, 1);
            else cnt.put(x, count + 1);
            if (cnt.get(x) > T) {
                minLen = i - start.get(x) + 1;
                T = cnt.get(x);
            }
            else if (cnt.get(x) == T)
                minLen = Math.min(i - start.get(x) + 1, minLen);
        }
        return minLen;

    }

    public void work() {
        int[] nums = {1,1,1,2,3,2,1};
        System.out.println(findShortestSubArray(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
