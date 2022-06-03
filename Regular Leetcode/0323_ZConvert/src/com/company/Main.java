package com.company;

import java.util.HashMap;

public class Main {

    void print(int[][] matrix) {
        int n = matrix.length;
        for (int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        int current = 0, i_max, j_max;
        int n = matrix.length;
        if (n % 2 == 0)
            i_max = j_max = n / 2;
        else {
            i_max = n/2;
            j_max = n/2 + 1;
        }
        for (int i=0;i<i_max;i++)
            for (int j=0;j<j_max;j++) {
                int current_x = i, current_y = j, new_x, new_y;
                current = matrix[i][j];
                for (int times = 0;times < 4;times++) {
                    new_x = current_y;
                    new_y = n - current_x - 1;
                    int temp = matrix[new_x][new_y];
                    matrix[new_x][new_y] = current;
                    current = temp;
                    current_x = new_x;
                    current_y = new_y;
                }

            }
    }

    public Main() {
        int[][] matrix = {{23, 34},{44,66}};
        rotate(matrix);
    }

    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
