package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet()),
                set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        Integer[] res =  set1.stream().toArray(Integer[]::new);
        int[] ans = new int[res.length];
        for (int i=0;i<ans.length;i++)
            ans[i] = res[i];
        return ans;
    }

    public void work() {
        int[] nums1 = {9,3,7}, nums2 = {6,4,1,0,0,4,4,8,7};
        int[] X = intersection(nums1, nums2);
        for (int t : X)
            System.out.print(t + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
