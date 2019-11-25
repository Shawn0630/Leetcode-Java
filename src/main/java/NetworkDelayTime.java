import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {

        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
        Set<Integer> visited = new HashSet<>();
        queue.add(new Node(K, 0));
        int[] dist = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;
        dist[0] = 0;


        while(!queue.isEmpty()) {
            Node node = queue.poll();
            visited.add(node.src);

            dist[node.src] = Math.min(dist[node.src], node.dist);

            for(int[] edge : times) {
                if (edge[0] == node.src && !visited.contains(edge[1])) {
                    queue.add(new Node(edge[1], dist[node.src] + edge[2]));
                }
            }
        }


        int res = Integer.MIN_VALUE;
        for(int dis : dist) {
            res = Math.max(res, dis);
        }


        return res == Integer.MAX_VALUE ?  -1 : res;
    }

    private class Node {
        int dist, src;
        Node(int src, int dist) {
            this.dist = dist;
            this.src = src;
        }
    }
}
