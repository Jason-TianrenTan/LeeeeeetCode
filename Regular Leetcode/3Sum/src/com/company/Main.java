package com.company;

import java.util.*;

public class Main {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<nums.length-2;i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int low = i + 1, high = nums.length - 1;
            int target = -nums[i];
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum > target)
                    high--;
                else if (sum < target)
                    low++;
                else {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    while (low < nums.length && (nums[low] == nums[low - 1]))
                        low++;
                }
            }
        }
        return ans;
    }


    void work() {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list : res) {
            for (int x : list)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
