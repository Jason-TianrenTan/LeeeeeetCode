package com.company;

import java.util.HashMap;

public class Main {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else countMap.put(c, 1);
        }
        int ans = 0;
        int plus = 0;
        if (countMap.entrySet().size() == 1)
            return s.length();
        for (HashMap.Entry<Character, Integer> entry : countMap.entrySet()) {
            ans += entry.getValue()/2;
            if (entry.getValue() % 2 == 1)
                plus = 1;
        }
        ans = ans * 2 + plus;
        return ans;
    }


    public Main() {
        String s = "ababababa";
        System.out.println(longestPalindrome(s));
    }

    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
