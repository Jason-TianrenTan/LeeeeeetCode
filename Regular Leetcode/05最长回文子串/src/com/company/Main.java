package com.company;

public class Main {

    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();

        //有“中心”
        int maxlen = 1, center = 0;
        for (int i=0;i<str.length;i++) {
            //find palindrome around str[i]
            int len = 1;//spread length
            while (i - len >= 0 && i + len < str.length && str[i - len] == str[i + len])
                len++;
            if (len > maxlen) {
                maxlen = len;
                center = i;
            }
        }
        //无“中心”
        int _maxlen = 0, right_center = 0;
        for (int i=1;i<str.length;i++) {
            int len = 1;
            while (i - len >=0 && i + len - 1 < str.length && str[i + len -1] == str[i - len])
                len++;
            if (len > _maxlen) {
                _maxlen = len;
                right_center = i;
            }
        }
        int centerLength = 2 * maxlen - 1, noncenterLength = 2 * (_maxlen - 1);
        if (centerLength >= noncenterLength)
            return new String(str, center - maxlen + 1, 2 * maxlen - 1);
        return new String(str, right_center - _maxlen + 1, 2 * (_maxlen - 1));
    }

    public void work() {
        System.out.println(longestPalindrome("baabbaa"));
    }

    public static void main(String[] args) {
	// write your code here
        new Main().work();
    }
}
