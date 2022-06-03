package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> intersectList = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersectList.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j])
                i++;
            else j++;
        }
        return intersectList.stream().mapToInt(num -> num).toArray();
    }

    public void work() {
        int[] a = {1};
        int[] b = {1,1};
        int[] res = intersect(a, b);
        for (int x : res)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
