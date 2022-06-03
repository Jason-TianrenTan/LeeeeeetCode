package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public int myAtoi(String s) {
        int pt = 0;
        boolean zeros = false;
        while (pt < s.length() && s.charAt(pt) == ' ')
            pt++;
        while (pt < s.length() && s.charAt(pt) == '0') {
            pt++;
            zeros = true;
        }
        boolean negative = false;
        if (pt < s.length() && s.charAt(pt) == '-') {
            if (zeros)
                return 0;
            negative = true;
            pt++;
        }
        while (pt < s.length() && s.charAt(pt) == '0') {
            pt++;
        }
        if (pt < s.length() && s.charAt(pt) == '+') {
            if (negative)
                return 0;
            pt++;
        }
        List<Integer> digits = new ArrayList<>();
        while (pt < s.length()) {
            char ch = s.charAt(pt);
            if (ch >= '0' && ch <= '9')
                digits.add(ch - '0');
            else break;
            pt++;
        }
        int current = 0;
        for (int top : digits) {
            if (negative) {
                if (current >= (Integer.MIN_VALUE + top)/ 10)
                    current = current * 10 - top;
                else return Integer.MIN_VALUE;
            } else {
                if (current <= (Integer.MAX_VALUE - top) / 10)
                    current = current * 10 + top;
                else return Integer.MAX_VALUE;
            }
        }
        return current;
    }

    public void work() {
        System.out.println(myAtoi("0-0"));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
