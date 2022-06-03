package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (countMap.containsKey(c))
                countMap.put(c, countMap.get(c) + 1);
            else countMap.put(c, 1);
        }
        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            boolean success = true;
            for (int j=0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (map.containsKey(c))
                    map.put(c, map.get(c) + 1);
                else map.put(c, 1);
                if (!countMap.containsKey(c) || map.get(c) > countMap.get(c)) {
                    success = false;
                    break;
                }
            }
            if (success)
                ans += words[i].length();
        }
        return ans;
    }

    public Main() {
        String[] words = new String[]{"c"};
        String chars = "c";
        System.out.println(countCharacters(words, chars));
    }
    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
