package com.company;

public class Main {

    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] state = new int[1001];
        for (int[] trip : trips) {
            int num = trip[0], from = trip[1], to = trip[2];
            for (int i = from; i < to; i++) {
                state[i] += num;
                if (state[i] > capacity)
                    return false;
            }
        }
        return true;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
