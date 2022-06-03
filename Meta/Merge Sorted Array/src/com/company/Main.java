package com.company;

public class Main {

    public void work() {
        int[] nums1 = {0}, nums2 = {1};
        merge(nums1, 0, nums2, 1);
        for (int x : nums1)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().work();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int pos = m + n - 1;
        while (pos >= 0) {
            System.out.println(p1 + ", " + p2);
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] <= nums2[p2])
                    nums1[pos] = nums2[p2--];
                else nums1[pos] = nums1[p1--];
            }
            else {
                if (p1 < 0)
                    nums1[pos] = nums2[p2--];
                else if (p2 < 0) {
                    nums1[pos] = nums1[p1--];
                }
            }
            pos--;
        }
    }

}
