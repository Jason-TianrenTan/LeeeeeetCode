package com.company;

import java.util.*;

public class Main {

    void print(PriorityQueue<Integer> priorityQueue) {
        Iterator<Integer> iter = priorityQueue.iterator();
        while (iter.hasNext()) {
            int val = iter.next();
            System.out.print(val + " ");
        }
        System.out.println();
    }

    void printHash(HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + ", " + entry.getValue());
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer aLong, Integer t1) {
                if (aLong < t1)
                    return 1;
                if (aLong > t1)
                    return -1;
                return 0;
            }
        }),//最大堆
                big = new PriorityQueue<>();//最小堆
        HashMap<Integer, Integer> delete_small = new HashMap<>(),
                delete_big = new HashMap<>();
        int count = nums.length - k + 1;
        boolean debug = false;
        double[] ans = new double[count];
        for (int i=0;i<k;i++)
            small.add(nums[i]);
        for (int i=0;i<k/2;i++) {
            big.add(small.peek());
            small.poll();
        }
        if (k % 2 == 0)
            ans[0] = ((long)small.peek() + (long)big.peek())/2.0;
        else ans[0] = small.peek();
        int balance = 0;
        for (int i=1;i<count;i++) {
            int left = nums[i - 1], right = nums[k + i - 1];
            balance = 0;
            if (!small.isEmpty() && left <= small.peek()) {
                delete_small.put(left, delete_small.getOrDefault(left, 0) + 1);
                balance--;
            }
            else {
                delete_big.put(left, delete_big.getOrDefault(left, 0) + 1);
                balance++;
            }

            if (!small.isEmpty() && right <= small.peek()) {
                small.add(right);
                balance++;
            }
            else {
                big.add(right);
                balance--;
            }

            //System.out.println("Balance = " + balance);
            if (balance > 0) {
                big.add(small.peek());
                small.poll();
            } else if (balance < 0){
                small.add(big.peek());
                big.poll();
            }
//            System.out.println("To be deleted: \nSmall:");
//            printHash(delete_small);
//            System.out.println("Big:");
//            printHash(delete_big);
//            System.out.println();

            while (!small.isEmpty() && delete_small.getOrDefault(small.peek(), 0) > 0) {
             //   System.out.println("Delete from small : " + small.peek());
                delete_small.put(small.peek(), delete_small.get(small.peek()) - 1);
                small.poll();
            }
            while (!big.isEmpty() && delete_big.getOrDefault(big.peek(), 0) > 0) {
             //   System.out.println("Delete from big : " + big.peek());
                delete_big.put(big.peek(), delete_big.get(big.peek()) - 1);
                big.poll();
            }
            if (k % 2 == 0)
                ans[i] = ((long)small.peek() + (long)big.peek())/2.0;
            else ans[i] = small.peek();
           //System.out.println();
        }
        return ans;
    }

    public void work() {
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 3;
        double[] ans = medianSlidingWindow(nums, k);
        for (double x : ans) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
