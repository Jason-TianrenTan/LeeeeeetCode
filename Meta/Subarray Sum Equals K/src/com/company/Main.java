package com.company;

import java.util.*;

public class Main {

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        //key: sum value, value: list of indices
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) {
                ans += sumMap.get(sum - k).size();
            }
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
        return ans;
    }

    public void work() {
        int[] nums = {-1, 0,0,0,0,0,1};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
