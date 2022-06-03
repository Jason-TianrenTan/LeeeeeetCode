package com.company;

import java.util.HashMap;

public class Main {

    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> index = new HashMap<>();
        HashMap<Integer, Integer> longest = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            index.put(arr[i], i);
//            for (int j=0;j<i;j++)
//                longest.put(j * arr.length + i, 2);
        }
        int maxlen = -1;
        for (int i=1;i<arr.length;i++) {
            for (int j=0;j<i;j++) {
                int k = index.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0 && k < j) {
                    int FibLen = longest.getOrDefault(k * arr.length + j, 2) + 1;
                    longest.put(j * arr.length + i, FibLen);
                    maxlen = maxlen < FibLen ? FibLen : maxlen;
                }
            }
        }
        return maxlen >= 3 ? maxlen : 0;
    }

    public void work() {
        int[] arr = new int[]{1,2,3,7};
        System.out.println(lenLongestFibSubseq(arr));
    }

    public static void main(String[] args) {
        new Main().work();
    }

}
