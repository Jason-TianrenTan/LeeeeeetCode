package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.sort(nums);
        //f[i]: size of subset ending with nums[i]
        Map<Integer, Set<Integer>> subsets = new HashMap<>();
        for (int i = 0; i < n; i++) {
            subsets.put(nums[i], new HashSet<>());
            subsets.get(nums[i]).add(nums[i]);
        }
        Arrays.fill(f, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0 && f[i] + 1 > f[j]) {
                    f[j] = f[i] + 1;
                    Set<Integer> nSet = new HashSet<>(subsets.get(nums[i]));
                    nSet.add(nums[j]);
                    subsets.put(nums[j], nSet);
                }
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (f[i] > f[maxIndex]) 
                maxIndex = i;
        }
        return subsets.get(nums[maxIndex]).stream().collect(Collectors.toList());
    }

    public void work() {
        int[] nums = {3, 4, 16, 8};
        List<Integer> list = largestDivisibleSubset(nums);
        for (int i : list)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
