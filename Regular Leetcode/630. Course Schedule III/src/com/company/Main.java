package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    int[][] f;

    public int scheduleCourse(int[][] courses) {
        int maxDay = 0;
        for (int[] course : courses)
            maxDay = Math.max(maxDay, course[1]);
        Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
        int time = 0;

    }

    public void work() {
        int[][] courses = {
                {100, 200},
                {200, 1300},
                {1000, 1250},
                {2000, 3200}
        };
        System.out.println(scheduleCourse(courses));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
