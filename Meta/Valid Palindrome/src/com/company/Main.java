package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void work() {
        System.out.println(isPalindrome(",,,,,"));
    }

    public static void main(String[] args) {
        new Main().work();
    }

    public boolean isPalindrome(String s) {
        List<Character> chList = new ArrayList<>();
        char[] chs = s.toLowerCase().toCharArray();
        for (char c : chs) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'))
                chList.add(c);
        }
        int st = 0, ed = chList.size() - 1;
        while (st <= ed) {
            if (chList.get(st) != chList.get(ed))
                return false;
            st++;
            ed--;
        }
        return true;
    }

}
