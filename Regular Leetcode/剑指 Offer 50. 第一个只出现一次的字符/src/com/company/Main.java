package com.company;

public class Main {

    public char firstUniqChar(String s) {
        int[] appeared = new int[26];
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            appeared[c - 'a']++;
        }
        for (int i=0;i<s.length();i++)
            if (appeared[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        return ' ';
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
