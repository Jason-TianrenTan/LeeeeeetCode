package com.company;

public class Main {

    public int expandStr(String s, int left, int right) {
        int expand = 0;
        while (left - expand >= 0 && right + expand < s.length()
                && s.charAt(left - expand) == s.charAt(right + expand)) {
            expand++;
        }
        return expand - 1;
    }

    public String longestPalindrome(String s) {
        String ans = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            //center s[i]
            int len1 = 0, len2 = 0;
            int left = i, right = i;
            int expand1 = 0, expand2 = 0;
            //case ...xx...
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                expand1 = expandStr(s, i, i + 1);
                len1 = 2 + 2 * expand1;
            }
            //case ...x...
            expand2 = expandStr(s, i, i);
            len2 = 1 + 2 * expand2;
            String str = "";
            int compLen = 0;
            if (len1 > len2) {
                str = s.substring(i - expand1, i + 2 + expand1);
                compLen = len1;
            }
            else {
                str = s.substring(i - expand2, i + 1 + expand2);
                compLen = len2;
            }
            if (compLen > maxLen) {
                maxLen = compLen;
                ans = str;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(new Main().longestPalindrome("asdf234sdafa"));
    }
}
