package com.company;

import java.util.*;

public class Main {

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();

        public void turnRight();

        // Clean the current cell.
        public void clean();
    }

    //面朝各个方向的时候move如何动
    private static final int[][] MOVE = {
            //up:
            {0, 1},
            //left
            {-1, 0},
            //down
            {0, -1},
            //right
            {1, 0},
    };
    private static final int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
    String[] dstr = {"Up", "Left", "Down", "Right"};

    private void setVisited(int offset_x, int offset_y) {
        visited.putIfAbsent(offset_x, new HashMap<>());
        visited.get(offset_x).put(offset_y, true);
    }

    private boolean hasVisited(int offset_x, int offset_y) {
        if (visited.containsKey(offset_x))
            return visited.get(offset_x).getOrDefault(offset_y, false);
        return false;
    }

    private void turnLeft(Robot robot) {
        robot.turnLeft();
        direction = (direction + 1) % 4;
    }

    private void turnRight(Robot robot) {
        robot.turnRight();
        direction = (direction + 3) % 4;
    }

    //假设机器人开始面朝的方向为“上”
    int direction = UP;
    int x, y;

    private void dfs(Robot robot) {
        setVisited(x, y);
        //   System.out.println("Clean (" + x + ", " + y + ")");
        robot.clean();
        int nextX, nextY;
        int originalX = x, originalY = y;
        for (int i = 0; i < 4; i++) {
            //System.out.println("Current direction: " + dstr[direction]);
            if (i == 1)
                turnLeft(robot);
            if (i == 2)
                turnRight(robot);
            if (i == 3) {
                turnRight(robot);
                turnRight(robot);
            }
            //System.out.println(i + " Moving direction: " + dstr[direction]);
            nextX = MOVE[direction][0] + x;
            nextY = MOVE[direction][1] + y;
            //System.out.println("Next pos = (" + nextX + ", " + nextY + ")");

            if (!hasVisited(nextX, nextY) && robot.move()) {
                x = nextX;
                y = nextY;
                dfs(robot);
                //回溯
                //   System.out.println("Move back to (" + originalX + ", " + originalY + ")");
                turnRight(robot);
                turnRight(robot);
                robot.move();
                x = originalX;
                y = originalY;
                turnRight(robot);
                turnRight(robot);
            }
            if (i == 1) {
                turnRight(robot);
            }
            if (i == 2) {
                turnLeft(robot);
            }
            if (i == 3) {
                turnLeft(robot);
                turnLeft(robot);
            }

        }

    }

    Map<Integer, Map<Integer, Boolean>> visited;

    public void cleanRoom(Robot robot) {
        visited = new HashMap<>();
        x = 0;
        y = 0;
        dfs(robot);
    }
    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
