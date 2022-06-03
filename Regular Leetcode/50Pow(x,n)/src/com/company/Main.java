package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        long power = n;
        double base = x, current = 1;
        List<Integer> path = new ArrayList<>();
        if (n < 0) {
            power = -power;
            base = 1 / x;
        }
        while (power > 0) {
            if (power % 2 == 1) {
                path.add(1);
                power -= 1;
            } else {
                path.add(2);
                power /= 2;
            }
        }
        for (int i = path.size() - 1; i >= 0; i--) {
            if (path.get(i) == 1)
                current *= base;
            else current *= current;
        }
        return current;
    }

    public void work() {
        System.out.println(myPow(2.0, 13));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
