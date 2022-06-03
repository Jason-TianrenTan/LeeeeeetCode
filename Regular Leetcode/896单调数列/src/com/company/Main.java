package com.company;

public class Main {

    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for (int i=1;i<A.length;i++) {
            if (A[i] < A[i - 1])
                inc = false;
            if (A[i] > A[i - 1])
                dec = false;
        }
        return inc || dec;
    }

    public void work() {
        int[] nums = {1, 1, 1};
        System.out.println(isMonotonic(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
