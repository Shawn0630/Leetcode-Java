import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ReachableNodesInSubdividedGraph {
    public int reachableNodes(int[][] edges, int M, int N) {
        if (edges == null) {
            return 0;
        }

        int[] dist = new int[N];
        for(int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        Set<Integer> visited = new HashSet<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited.add(node.src);
            dist[node.src] = Math.min(dist[node.src], node.dist);
            for(int[] next: edges) {
                if (next[0] == node.src && !visited.contains(next[1])) {
                    queue.offer(new Node(next[1], dist[node.src] + next[2]));
                }
            }
        }

        int counter = 0;
        for(int d : dist) {
            if (d <= M) {
                counter++;
            }
        }


        return counter;
    }

    private class Node {
        int src;
        int dist;

        Node(int src, int dist) {
            this.src = src;
            this.dist = dist;
        }
    }
}
