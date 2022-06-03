package com.company;

import java.util.ArrayList;

public class Main {

    public int longestOnes(int[] A, int K) {
        int count = 0;
        int ans = 0;
        int left = 0, right = 0;
        for (right=0;right<A.length;right++) {
            if (A[right] == 0)
                count++;
            while (count > K) {
                if (A[left] == 0)
                    count--;
                left++;
            }
            int len = right - left + 1;
            ans = ans > len ? ans : len;
        }
        return ans;
    }

    public void work() {
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;
        System.out.println(longestOnes(A, K));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
