import java.util.ArrayDeque;
import java.util.Queue;

public class Maze {

    private class Point {
        int x;
        int y;
        int minStepFromOrigin;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int minStepFromOrigin) {
            this(x, y);
            this.minStepFromOrigin = minStepFromOrigin;
        }
    }

    public boolean hasPath(int[][] maze, int startX, int startY) {
        if (maze == null || maze.length == 0 ||
            startX > maze.length || startY > maze[0].length) {
            return false;
        }

        boolean[][] hasVisited = new boolean[maze.length][maze[0].length];

        Queue<Point> queue = new ArrayDeque<>();

        queue.add(new Point(startX, startY, 0));
        hasVisited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (maze[point.x][point.y] == 9) {
                return true;
            }

            if (point.x - 1 >= 0 && maze[point.x - 1][point.y] > 0 &&
                !hasVisited[point.x - 1][point.y]) {
                queue.add(new Point(point.x - 1, point.y));
                hasVisited[point.x - 1][point.y] = true;
            }

            if (point.y - 1 >= 0 && maze[point.x][point.y - 1] > 0 &&
                !hasVisited[point.x][point.y - 1]) {
                queue.add(new Point(point.x, point.y - 1));
                hasVisited[point.x][point.y - 1] = true;
            }

            if (point.x + 1 < maze.length && maze[point.x + 1][point.y] > 0 &&
                !hasVisited[point.x + 1][point.y]) {
                queue.add(new Point(point.x + 1, point.y));
                hasVisited[point.x + 1][point.y] = true;
            }

            if (point.y + 1 < maze[point.x].length && maze[point.x][point.y + 1] > 0 &&
                !hasVisited[point.x][point.y + 1]) {
                queue.add(new Point(point.x, point.y + 1));
                hasVisited[point.x][point.y + 1] = true;
            }
        }

        return false;
    }

    public int minPath(int[][] maze, int startX, int startY) {
        if (maze == null || maze.length == 0 ||
                startX > maze.length || startY > maze[0].length) {
            return Integer.MAX_VALUE;
        }

        boolean[][] hasVisited = new boolean[maze.length][maze[0].length];
        int minCount = Integer.MAX_VALUE;

        Queue<Point> queue = new ArrayDeque<>();

        queue.add(new Point(startX, startY));
        hasVisited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (maze[point.x][point.y] == 9) {
                minCount = Math.min(point.minStepFromOrigin, minCount);
            }

            if (point.x - 1 >= 0 && maze[point.x - 1][point.y] > 0 &&
                    !hasVisited[point.x - 1][point.y]) {
                queue.add(new Point(point.x - 1, point.y, point.minStepFromOrigin + 1));
                hasVisited[point.x - 1][point.y] = true;
            }

            if (point.y - 1 >= 0 && maze[point.x][point.y - 1] > 0 &&
                    !hasVisited[point.x][point.y - 1]) {
                queue.add(new Point(point.x, point.y - 1, point.minStepFromOrigin + 1));
                hasVisited[point.x][point.y - 1] = true;
            }

            if (point.x + 1 < maze.length && maze[point.x + 1][point.y] > 0 &&
                    !hasVisited[point.x + 1][point.y]) {
                queue.add(new Point(point.x + 1, point.y, point.minStepFromOrigin + 1));
                hasVisited[point.x + 1][point.y] = true;
            }

            if (point.y + 1 < maze[point.x].length && maze[point.x][point.y + 1] > 0 &&
                    !hasVisited[point.x][point.y + 1]) {
                queue.add(new Point(point.x, point.y + 1, point.minStepFromOrigin + 1));
                hasVisited[point.x][point.y + 1] = true;
            }
        }

        return minCount;
    }
}
