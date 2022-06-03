package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int start = 1, n = nums.length;
        while (start <= n) {
            int next = Math.abs(nums[start - 1]);
            if (nums[next - 1] > 0)
                nums[next - 1] *= -1;
            start++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                ans.add(i + 1);
        }
        return ans;
    }

    public void work() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers(nums);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
