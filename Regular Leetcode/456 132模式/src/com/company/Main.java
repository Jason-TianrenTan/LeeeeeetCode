package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    /*
         2 // maxK
              3 // candidates
    1 // nums[i]
     */
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        int maxK = Integer.MIN_VALUE;//实际2
        Deque<Integer> candidates = new LinkedList<>();//3, 候选2
        candidates.push(nums[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            System.out.println("Nums[" + i + "] = " + nums[i] + ", maxK = " + maxK);
            if (nums[i] < maxK)
                return true;
            while (!candidates.isEmpty() && nums[i] > candidates.peek()) {
                maxK = candidates.pop();
            }
            System.out.println("current maxK = " + maxK);
            if (nums[i] > maxK)
                candidates.push(nums[i]);
            System.out.print("Stack : ");
            for (int x : candidates)
                System.out.print(x + " ");
            System.out.println();
        }
        return false;
    }

    public void work() {
        int[] nums = {2,6,5,3,4};
        System.out.println(find132pattern(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
