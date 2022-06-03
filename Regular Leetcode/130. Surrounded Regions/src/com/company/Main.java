package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private void search(int row, int col, char[][] board, boolean[][] visited, int m, int n) {
        if (visited[row][col] || board[row][col] == 'X')
            return;
        visited[row][col] = true;
        for (int[] dir : directions) {
            int new_row = row + dir[0], new_col = col + dir[1];
            if (new_row >= 0 && new_row < m && new_col >= 0 && new_col < n)
                search(new_row, new_col, board, visited, m, n);
        }
    }

    public void solve(char[][] board) {
        List<Pair> coordinates = new ArrayList<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                coordinates.add(new Pair(0, j));
            if (board[m - 1][j] == 'O')
                coordinates.add(new Pair(m - 1, j));
        }

        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O')
                coordinates.add(new Pair(i, 0));
            if (board[i][n - 1] == 'O')
                coordinates.add(new Pair(i, n - 1));
        }

        for (Pair coordinate : coordinates) {
            search(coordinate.x, coordinate.y, board, visited, m, n);
        }
        
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
    }

    public void work() {
        char[][] board = {
                {'X', 'O'}
        };
        solve(board);
        int m = board.length, n = board[0].length;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
