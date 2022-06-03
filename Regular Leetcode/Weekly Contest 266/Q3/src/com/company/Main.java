package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    int smallest;
    public int[] sortArray(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        return list.stream().mapToInt(i -> i).toArray();
    }

    public int minimizedMaximum(int n, int[] quantities) {
        quantities = sortArray(quantities);
        int m = quantities.length;
        if (n == m)
            return quantities[0];
        int left = 1, right = quantities[0] + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int i=0;i<m;i++) {
                int val = 0;
                if (quantities[i] % mid != 0)
                    val = 1;
                sum += val + quantities[i] / mid;
            }
            if (sum > n) {
                left = mid + 1;
            }
            else right = mid;
        }
        return left;
    }

    public void work() {
        int n = 6;
        int[] q = {11, 6};
        System.out.println(minimizedMaximum(n, q));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
