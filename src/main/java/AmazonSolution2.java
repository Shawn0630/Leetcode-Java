import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class AmazonSolution2 {
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        if (lot == null || lot.size() == 0) {
            return -1;
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 0));
        boolean[][] hasVisited = new boolean[lot.size()][lot.get(0).size()];

        int minStep = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (lot.get(point.x).get(point.y) == 9) {
                minStep = Math.min(minStep, point.minStepFromOrigin);
            }

            if (point.x - 1 >= 0 && lot.get(point.x - 1).get(point.y) > 0 &&
                    !hasVisited[point.x - 1][point.y]) {
                queue.add(new Point(point.x - 1, point.y, point.minStepFromOrigin + 1));
                hasVisited[point.x - 1][point.y] = true;
            }

            if (point.y - 1 >= 0 && lot.get(point.x).get(point.y - 1) > 0 &&
                    !hasVisited[point.x][point.y - 1]) {
                queue.add(new Point(point.x, point.y - 1, point.minStepFromOrigin + 1));
                hasVisited[point.x][point.y - 1] = true;
            }

            if (point.x + 1 < lot.size() && lot.get(point.x + 1).get(point.y) > 0 &&
                    !hasVisited[point.x + 1][point.y]) {
                queue.add(new Point(point.x + 1, point.y, point.minStepFromOrigin + 1));
                hasVisited[point.x + 1][point.y] = true;
            }

            if (point.y + 1 < lot.get(point.x).size() && lot.get(point.x).get(point.y + 1) > 0 &&
                    !hasVisited[point.x][point.y + 1]) {
                queue.add(new Point(point.x, point.y + 1, point.minStepFromOrigin + 1));
                hasVisited[point.x][point.y + 1] = true;
            }
        }

        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

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
}
