package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0)
            return 0;
        Map<Character, Integer> freq = new HashMap<>();
        int st = 0;
        int len = 0;
        for (int ed = 0; ed < s.length(); ed++) {
            char curr = s.charAt(ed);
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
            while (freq.size() > k) {
                char delete = s.charAt(st);
                freq.put(delete, freq.get(delete) - 1);
                if (freq.get(delete) == 0)
                    freq.remove(delete);
                st++;
            }
            len = Math.max(len, ed - st + 1);
        }
        return len;
    }

    public void work() {
        System.out.println(lengthOfLongestSubstringKDistinct("x", 2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
