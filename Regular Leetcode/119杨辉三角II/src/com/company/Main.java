package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public List<Integer> getRow(int rowIndex) {
        int[] tri = new int[rowIndex + 1];
        tri[0] = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=2;i<=rowIndex + 1;i++) {
            int last = 1;//tri[j-1]
            for (int j=1;j<i-1;j++) {
                int temp = tri[j];
                tri[j] = last + tri[j];
                last = temp;
            }
            tri[i-1] = 1;
        }
        for (int i=0;i<rowIndex + 1;i++)
            ans.add(tri[i]);
        return ans;
    }

    public void work() {
        for (int x : getRow(1))
            System.out.println(x);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
