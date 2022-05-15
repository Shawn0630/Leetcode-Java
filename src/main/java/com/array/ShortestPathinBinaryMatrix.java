package com.array;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    // [[0,1],
    //  [1,0]]

    // return 2

    // constraints/assumptions
    //
    public int shortestPathBinaryMatrix(int[][] grid) {
        int x = 0;
        int y = 0;
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        if (grid[x][y] == 1) {
            return -1;
        }


        queue.offer(new Pair<>(x, y));
        grid[x][y] = 1;


        int count = 1;
        while (!queue.isEmpty()) {
            for(int i = queue.size() - 1; i >= 0; i--) {
                Pair<Integer, Integer> pair = queue.poll();
                int curX = pair.getKey();
                int curY = pair.getValue();

                if (curX == row - 1 && curY == col - 1) {
                    return count;
                }

                int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},
                        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

                for (int[] dir : dirs) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];

                    if (nextX >= 0 && nextX < grid.length &&
                            nextY >= 0 && nextY < grid[0].length) {
                        if (grid[nextX][nextY] == 0) {
                            queue.offer(new Pair<>(nextX, nextY));
                            grid[nextX][nextY] = 1;
                        }
                    }
                }
            }

            count++;
        }

        return -1;
    }
}
