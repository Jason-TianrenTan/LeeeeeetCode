package com.company;

import java.util.*;

public class Main {

    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        int diff = 0;
        for (int x : nums)
            bitmask ^= x;
        //bitmask now equals x^y
        diff = bitmask & (-bitmask);
        int x = 0;
        for (int y : nums) {
            if ((y & diff) != 0)
                x ^= y;
        }
        return new int[]{x, bitmask ^ x};
    }

    public void work() {
//        int[] nums = {1, 2, 3, 1, 2, 5};
//        int[] ans = singleNumber(nums);
//        System.out.println(ans[0] + ", " + ans[1]);
        String[] a = {"abc", "2", "10", "0"};
        Arrays.sort(a);
        for (String s : a)
            System.out.println(s);
    }

    static int count = 0;

    public static void main(String[] args) {
        new Main().work();

    }
}
