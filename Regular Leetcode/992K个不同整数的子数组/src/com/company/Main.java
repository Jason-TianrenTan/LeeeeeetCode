package com.company;

import java.util.*;

public class Main {

    void printMap(HashMap<Integer, Integer> freqMap) {
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
    public int getMaxK_Res(int[] A, int K) {
        System.out.println("K = " + K);
        int left = 0, right = 0;
        int result = 0, count = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int[] freq = new int[A.length + 1];
//        while (right < A.length) {
//            if (freq[A[right]] == 0)
//                count++;
//            freq[A[right]]++;
//            right++;
//            while (count > K) {
//                freq[A[left]]--;
//                System.out.println(freq[A[left]]);
//                if (freq[A[left]] == 0)
//                    count--;
//                left++;
//            }
//            System.out.println("Right = " + right + ", left = " + left);
//            result += right - left;
//        }

        while (right < A.length) {
            if (freqMap.getOrDefault(A[right], -1) <= 0) {
                freqMap.put(A[right], 1);
                count++;
            } else freqMap.put(A[right], freqMap.get(A[right]) + 1);
            right++;
            while (count > K) {
                freqMap.put(A[left], freqMap.get(A[left]) - 1);
                if (freqMap.get(A[left]) == 0)
                    count--;
                left++;
            }

            result += right - left;
        }
        return result;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return getMaxK_Res(A, K) - getMaxK_Res(A, K-1);
    }


    /*
    超时，通过样例45/55
    public int subarraysWithKDistinct(int[] A, int K) {
        int ans = 0;
        for (int i=0;i<A.length;i++) {
            int end = i;
            Set<Integer> numSet = new HashSet<>();
            while (numSet.size() <= K && end < A.length) {
                numSet.add(A[end]);
                if (numSet.size() == K)
                    ans++;
                end++;
            }
        }
        return ans;
    }*/

    public void work() {
        int[] A = {1,2,1,2,3};
        int K = 2;
        System.out.println(subarraysWithKDistinct(A, K));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
