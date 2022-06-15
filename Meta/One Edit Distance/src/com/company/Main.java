package com.company;

public class Main {

    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1)
            return false;
        if (t.length() <= s.length()) {
            String temp = t;
            t = s;
            s = temp;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (len != t.length()) {
                    for (int j = i; j < len; j++) {
                        if (s.charAt(j) != t.charAt(j + 1))
                            return false;
                    }
                } else {
                    for (int j = i + 1; j < len; j++) {
                        if (s.charAt(j) != t.charAt(j))
                            return false;
                    }
                }
                return true;
            }
        }
        return t.length() == len + 1;
    }

    public void work() {
        System.out.println(isOneEditDistance("ab", "acb"));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
