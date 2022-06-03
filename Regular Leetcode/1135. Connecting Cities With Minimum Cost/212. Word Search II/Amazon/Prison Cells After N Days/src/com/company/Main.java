package com.company;

public class Main {

    //Day 15 = Day 1
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[][] preCalc = new int[16][cells.length];
        preCalc[0] = cells;
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                if (preCalc[i - 1][j - 1] == preCalc[i - 1][j + 1])
                    preCalc[i][j] = 1;
            }
        }
        int index = n % 14;
        if (index == 0)
            return preCalc[14];
        return preCalc[index];
    }

    public void work() {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        prisonAfterNDays(cells, 1000000000);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
