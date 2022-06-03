package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> disappear = new ArrayList<>();
        for (int i=0;i<nums.length;i++)
            queue.add(nums[i]);
        int last = 0, current = 0;
        while (queue.peek() != null) {
            current = queue.peek();
            queue.poll();
            if (current != last) {
                for (int i = last + 1; i < current; i++)
                    disappear.add(i);
            }
            last = current;
        }
        for (int i=last + 1;i<=nums.length;i++)
            disappear.add(i);
        return disappear;
    }

    public void work() {
        int[] nums = {3,3,3,3};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
