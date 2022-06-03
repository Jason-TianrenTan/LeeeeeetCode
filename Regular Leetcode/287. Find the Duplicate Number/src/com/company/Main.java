package com.company;

public class Main {

//    public int findDuplicate(int[] nums) {
//        int index = 0;
//        while (true) {
//            int target = nums[index];
//            if (target == index)
//                return index;
//            nums[index] = index;
//            index = target;
//        }
//    }

    public int findDuplicate(int[] nums) {
        int tortoise = nums[0], hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    public void work() {
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(findDuplicate(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
