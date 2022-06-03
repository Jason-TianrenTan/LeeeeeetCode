package com.company;

import java.util.*;

public class Main {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] f = new int[len][len];
        f[0][0] = triangle.get(0).get(0);
        for (int i=1;i<len;i++) {
            for (int j=0;j<=i;j++) {
                int prev;
                if (j == 0)
                    prev = f[i-1][j];
                else if (j == i)
                    prev = f[i-1][j-1];
                else prev = Math.min(f[i-1][j], f[i-1][j-1]);
                f[i][j] = prev + triangle.get(i).get(j);
            }
        }
        int min = f[len-1][0];
        for (int i=1;i<len;i++) {
            min = Math.min(min, f[len-1][i]);
        }
        return min;
    }

    public void work() {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        int[][] T = {{-10}};
        for (int i=0;i<T.length;i++) {
            List<Integer> tri = new ArrayList<>();
            for (int j=0;j<T[i].length;j++)
                tri.add(T[i][j]);
            triangle.add(tri);
        }
        System.out.println(minimumTotal(triangle));

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
