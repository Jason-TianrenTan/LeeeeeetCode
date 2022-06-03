package com.company;

import java.util.*;

public class Main {

    Map<Integer, Set<Integer>> containsPair;
    int[] powers;

    void get2s() {
        int res = 1;
        List<Integer> power = new ArrayList<>();
        while (res < 200001) {
            power.add(res);
            res *= 2;
        }
        powers = power.stream().mapToInt(i -> i).toArray();
    }

    int solution(int[] a) {
        get2s();
        containsPair = new HashMap<>();
        int ans = 0;
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            indices.putIfAbsent(a[i], new ArrayList<>());
            indices.get(a[i]).add(i);
            containsPair.putIfAbsent(i, new HashSet<>());
        }
        for (int power : powers) {
            for (int i = 0; i < a.length; i++) {
                int find = power - a[i];
                if (indices.containsKey(find)) {
                    List<Integer> indexList = indices.get(find);
                    for (int j : indexList) {
                        if (!containsPair.get(i).contains(j)) {
                            containsPair.get(i).add(j);
                            containsPair.get(j).add(i);
                            ans++;
                        }
                    }
                }

            }
        }
        return ans;
    }

    public void work() {
        int[] a = {-1, 1, 2, 3};
        System.out.println(solution(a));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
