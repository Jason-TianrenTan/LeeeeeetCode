package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        int[] f = new int[nums.length];
        HashMap<Integer, Integer> pre = new HashMap<>();
        int maxLen = 1, end = 0;
        for (int i=0;i<nums.length;i++)
            f[i] = 1;
        for (int i=1;i<nums.length;i++) {
            for (int j=0;j<i;j++) {
                if (nums[i] % nums[j] == 0 && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                    pre.put(i, j);
                }
            }
            if (f[i] > maxLen) {
                maxLen = f[i];
                end = i;
            }
        }
        int currentIndex = end;
        while (currentIndex != -1) {
            //System.out.println(nums[currentIndex]);
            ans.add(nums[currentIndex]);
            currentIndex = pre.getOrDefault(currentIndex, -1);
        }
        return ans;
    }

    public void work() {
        int[] nums = {12};
        List<Integer> list = largestDivisibleSubset(nums);
        for (int x : list)
            System.out.println(x);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
