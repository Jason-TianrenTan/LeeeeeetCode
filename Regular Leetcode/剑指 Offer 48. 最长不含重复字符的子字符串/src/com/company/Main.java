package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, n = s.length();
        int[] f = new int[n + 1];
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (indexMap.containsKey(c))
                f[i] = Math.min(i - indexMap.get(c), f[i - 1] + 1);
            else f[i] = f[i - 1] + 1;
            indexMap.put(c, i);
            maxLen = Math.max(maxLen, f[i]);
        }
        return maxLen;
    }

    public void work() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
