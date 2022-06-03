package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private char[][] map = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    List<String> ans = new ArrayList<>();

    public void find(String digits, StringBuilder sb, int index) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0' - 2;
        for (char c : map[digit]) {
            sb.append(c);
            find(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return ans;
        StringBuilder sb = new StringBuilder();
        find(digits, sb, 0);
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
