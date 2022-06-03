package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {


    public int longestSubarray(int[] nums, int limit) {
        int start = 0, end = 0;
        PriorityQueue<Integer> small = new PriorityQueue<>(), big = new PriorityQueue<>(Collections.reverseOrder());
        int diff = 0;
        int maxLen = 1;
        HashMap<Integer, Integer> deleteBig = new HashMap<>(), deleteSmall = new HashMap<>();
        small.add(nums[0]);
        big.add(nums[0]);
        while (start < nums.length) {
            while (diff <= limit && end < nums.length) {
                int len = end - start + 1;
                if (len > maxLen) {
                    maxLen = len;
                    System.out.println(end + " -> " + start + ", maxlen = " + maxLen);
                }
                end++;
                if (end < nums.length) {
                    System.out.println("Add " + nums[end]);
                    small.add(nums[end]);
                    big.add(nums[end]);
                    diff = big.peek() - small.peek();
                    System.out.println("Diff: " + big.peek() + " - " + small.peek() + " = " + diff);
                }
            }
            if (!deleteBig.containsKey(nums[start]))
                deleteBig.put(nums[start], 0);
            deleteBig.put(nums[start], deleteBig.get(nums[start]) + 1);
            while (!big.isEmpty() && deleteBig.getOrDefault(big.peek(), -1) > 0) {
                int val = big.peek();
                big.poll();
                deleteBig.put(val, deleteBig.get(val) - 1);
            }

            if (!deleteSmall.containsKey(nums[start]))
                deleteSmall.put(nums[start], 0);
            deleteSmall.put(nums[start], deleteSmall.get(nums[start]) + 1);
            while (!small.isEmpty() && deleteSmall.getOrDefault(small.peek(), -1) > 0) {
                int val = small.peek();
                small.poll();
                deleteSmall.put(val, deleteSmall.get(val) - 1);
            }

            if (!big.isEmpty() && !small.isEmpty())
                diff = big.peek() - small.peek();
            start++;
        }
        return maxLen;
    }

    public void work() {
        int[] nums = {1,2,3};
        int limit = 1;
        System.out.println(longestSubarray(nums, limit));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
