package com.company;

public class Main {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        //a >= b
        int len1 = a.length(), len2 = b.length();
        int carry = 0;
        int p1 = len1 - 1, p2 = len2 - 1;
        String res = "";
        while (p2 >= 0) {
            int sum = carry + a.charAt(p1) - '0' + b.charAt(p2) - '0';
            carry = sum / 2;
            sum = sum % 2;
            res = sum + res;
            p1--;
            p2--;
        }
        while (p1 >= 0) {
            int sum = carry + a.charAt(p1) - '0';
            carry = sum / 2;
            sum = sum % 2;
            res = sum + res;
            p1--;
        }
        if (carry > 0)
            res = carry + res;
        return res;
    }

    public void work() {
        System.out.println(addBinary("101", "101"));
    }
    public static void main(String[] args) {
        new Main().work();
    }
}
