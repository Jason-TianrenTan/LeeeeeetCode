package com.company;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public String add(String num1, String num2) {
        if (num1.length() > num2.length()) {
            String str = num1;
            num1 = num2;
            num2 = str;
        }
        int carry = 0;
        int len1 = num1.length(), len2 = num2.length();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len2 - len1; i++)
            temp.append('0');
        temp.append(num1);
        num1 = temp.toString();
        char[] chars = new char[len2 + 1];
        for (int i = len2 - 1; i >= 0; i--) {
            int result = num1.charAt(i) - '0' + num2.charAt(i) - '0' + carry;
            carry = result / 10;
            result %= 10;
            chars[i + 1] = (char) (result + '0');
        }
        int offset = 0, nlen = len2 + 1;
        if (carry > 0)
            chars[0] = (char) (carry + '0');
        else {
            offset = 1;
            nlen = len2;
        }
        return new String(chars, offset, nlen);
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int len1 = num1.length(), len2 = num2.length();
        String ans = "0";
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            List<Character> current = new ArrayList<>();
            for (int j = len2 - 1; j >= 0; j--) {
                int result = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                carry = result / 10;
                result %= 10;
                current.add((char) (result + '0'));
            }
            if (carry > 0)
                current.add((char) (carry + '0'));
            Collections.reverse(current);
            String cur_str = current.stream().map(String::valueOf).collect(Collectors.joining());
            for (int k = 0; k < len1 - 1 - i; k++)
                cur_str += "0";
            ans = add(ans, cur_str);
        }
        return ans;
    }

    public void work() {
        String num1 = "12", num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
