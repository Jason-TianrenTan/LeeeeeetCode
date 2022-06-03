package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = -x;
        }
        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % 10);
            x /= 10;
        }
        StringBuilder sb = new StringBuilder();
        digits.stream().forEach(d -> sb.append(d));
        String numString = sb.toString();
        if (!positive)
            numString = '-' + numString;

        try {
            int temp = Integer.parseInt(numString);
            return temp;
        } catch (Exception e) {
            return 0;
        }
    }

    public void work() {
        System.out.println(reverse(120));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
