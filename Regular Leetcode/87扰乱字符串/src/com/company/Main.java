package com.company;

import java.util.HashMap;

public class Main {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int len = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        for (int i=1;i<len;i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                    || (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))
            ) {
                return true;
            }
        }
        return false;
    }


    public void work() {
        String s1 = "greata", s2 = "argeat";
        System.out.println(isScramble(s1, s2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
