package com.company;

public class Main {

    static final int UP = 0, LEFT = 1, RIGHT = 2, DOWN = 3;
    static final int[][] DIR = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0}
    };
    boolean[][] visited;//x, y
    int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        return search(maze, start[0], start[1], destination[0], destination[1]);
    }

    public boolean search(int[][] maze, int row, int col, int dest_row, int dest_col) {
        // System.out.println("At " + row + ", " + col);
        if (row == dest_row && col == dest_col)
            return true;
        for (int i = 0; i < 4; i++) {
            int[] next = findNext(maze, row, col, i);
            //    System.out.println("Dir = " + i + ", next = " + next[0] + "," + next[1]);
            if (!visited[next[0]][next[1]]) {
                visited[next[0]][next[1]] = true;
                if (search(maze, next[0], next[1], dest_row, dest_col))
                    return true;
            }
        }
        return false;
    }

    //given a position and a direction, find the next position
    public int[] findNext(int[][] maze, int row, int col, int d) {
        int nrow = row + DIR[d][0], ncol = col + DIR[d][1];
        while (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && maze[nrow][ncol] == 0) {
            row += DIR[d][0];
            col += DIR[d][1];
            nrow += DIR[d][0];
            ncol += DIR[d][1];
        }
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        // write your code here
    }
}
