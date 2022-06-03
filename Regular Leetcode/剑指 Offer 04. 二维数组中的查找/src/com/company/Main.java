package com.company;

public class Main {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;
        if (m == 0)
            return false;
        int i = 0, j = m - 1;
        while (i < n && j > 0 ) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] < target)
                i++;
            else j--;
        }
        return false;
    }

    public void work() {
        int[][] matrix = {
                {1, 4},
                {2, 5},
                {8, 12},
                {10, 17},
                {19, 21},
                {23, 39},
                {24, 40},
                {25, 41}
        };
        System.out.println(findNumberIn2DArray(matrix, 41));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
