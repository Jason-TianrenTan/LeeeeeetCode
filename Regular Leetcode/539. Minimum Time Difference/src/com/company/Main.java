package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static final int MINUTES_IN_DAY = 24 * 60;

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int minDiff = MINUTES_IN_DAY;
        int n = timePoints.size();
        for (int i = 0; i < n - 1; i++) {
            int diff = getDiff(timePoints.get(i), timePoints.get(i + 1));
            minDiff = Math.min(minDiff, diff);
        }
        minDiff = Math.min(minDiff, getDiff(timePoints.get(n - 1), timePoints.get(0)));
        return minDiff;
    }

    public int[] getHoursAndMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]), minutes = Integer.parseInt(parts[1]);
        return new int[]{hours, minutes};
    }

    public int getDiff(String t1, String t2) {
        int[] time1 = getHoursAndMinutes(t1), time2 = getHoursAndMinutes(t2);
        int h1 = time1[0], m1 = time1[1], h2 = time2[0], m2 = time2[1];
        return ((h2 - h1) * 60 + m2 - m1 + MINUTES_IN_DAY) % MINUTES_IN_DAY;
    }


    public void work() {
        System.out.println(findMinDifference(Arrays.asList("11:23", "23:23")));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
