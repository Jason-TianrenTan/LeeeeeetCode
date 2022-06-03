package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    Map<String, Boolean> status;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        status = new HashMap<>();
        char[] visited = new char[nums.length];
        Arrays.fill(visited, '0');
        for (int x : nums)
            sum += x;
        if (sum % k != 0)
            return false;
        int partial = sum / k;
        return search(nums, k, 0, partial, visited);
    }

    public boolean search(int[] nums, int k, int current, int target, char[] visited) {
        if (current == target) {
            k--;
            if (k == 0)
                return true;
            return search(nums, k, 0, target, visited);
        }

        String statString = new String(visited);
        if (status.containsKey(statString))
            return status.get(statString);
        for (int i = 0; i < nums.length; i++) {
            //try nums[i]
            if (visited[i] == '0' && current + nums[i] <= target) {
                current += nums[i];
                visited[i] = '1';
                if (search(nums, k, current, target, visited)) {
                    status.put(statString, true);
                    return true;
                }
                current -= nums[i];
                visited[i] = '0';
            }
        }
        status.put(statString, false);
        return false;
    }

    public void work() {
        int[] nums = {3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269};
        System.out.println(canPartitionKSubsets(nums, 5));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
