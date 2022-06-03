package com.company;

import java.util.*;

public class Main {

    class KthLargest {

        int size = 0;
        int k;
        PriorityQueue<Integer> bigger;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            Integer[] numbers = new Integer[nums.length];
            for (int i=0;i<nums.length;i++)
                numbers[i] = nums[i];
            Arrays.sort(numbers, Collections.reverseOrder());
            bigger = new PriorityQueue<>();
            for (int i=0;i<Math.min(k, nums.length)  ;i++)
                bigger.add(numbers[i]);
            size = numbers.length;
        }

        public int add(int val) {
            if (size < k || val >= bigger.peek()) {
                bigger.add(val);
                size++;
                if (size > k)
                    bigger.poll();
            }
            System.out.println(bigger.peek());
            return bigger.peek();
        }

    }

    public void work() {
        KthLargest kthLargest = new KthLargest(1, new int[]{});
        kthLargest.add(-3);   // return 4
        kthLargest.add(-2);   // return 5
        kthLargest.add(-4);  // return 5
        kthLargest.add(0);   // return 8
        kthLargest.add(4);   // return 8
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
