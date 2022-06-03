package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public Main() {
        String s = "aaaaabbxxxxzyyyyy";
        System.out.println(largeGroupPositions(s).toString());
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        char[] chs = s.toCharArray();
        int current = 0, index = 1, start = 0, end = 0;
        while (index < chs.length) {
            current = 1;
            start = index - 1;
            while (index < chs.length && chs[index] == chs[index - 1]) {
                index++;
                current++;
            }
            if (current >= 3) {
                end = index - 1;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                result.add(list);
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
