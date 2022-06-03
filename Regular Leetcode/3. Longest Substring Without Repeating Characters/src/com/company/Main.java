package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int maxLen = 0;
        int start = 0, end = 0;//end inclusive
        while (end < s.length() && start <= end) {
            char endChar = s.charAt(end);
            seen.put(endChar, seen.getOrDefault(endChar, 0) + 1);
            if (seen.get(endChar) > 1) {
                maxLen = Math.max(maxLen, end - start);
                while (seen.get(s.charAt(end)) > 1) {
                    seen.put(s.charAt(start), seen.get(s.charAt(start)) - 1);
                    start++;
                }
            }
            end++;
        }
        return Math.max(maxLen, end - start);
    }

    public void work() {
        System.out.println(lengthOfLongestSubstring("axyzchxygg"));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
