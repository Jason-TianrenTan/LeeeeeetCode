package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    int ranking(int m, int n, int x) {
        int ranking = 0;
        for (int i = 1; i <= n; i++)
            ranking += Math.min(m, x / i);
        return ranking;
    }

    public int findKthNumber(int m, int n, int k) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        //m is larger, n is smaller
        int maxRange = 2 * k;
        int left = 1, right = maxRange;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int ranking = ranking(m, n, mid);
            if (ranking < k)
                left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public void work() {
        int m = 3, n = 4, k = 10;
        System.out.println(findKthNumber(m, n, k));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
