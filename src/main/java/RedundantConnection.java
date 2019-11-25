import java.util.HashMap;
import java.util.Map;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer,Node> graph=new HashMap();
        for(int[] edge:edges)
            if(!addEdges(graph,edge[0],edge[1])) return edge;
        return null;
    }

    private class Node {
        int val;
        Node parent;
        Node(int val) {
            this.val = val;
            parent = this;
        }
    }

    private Node findRoot(Node node) {
        if (node.parent != node) node.parent = findRoot(node.parent);
        return node.parent;
    }

    private boolean addEdges(Map<Integer, Node> graph, int source, int target) {
        graph.computeIfAbsent(source, ignore -> new Node(source));
        graph.computeIfAbsent(target, ignore -> new Node(target));
        Node sourceRoot = graph.get(source);
        Node targetRoot = graph.get(target);
        if (sourceRoot == targetRoot) return false;
        if (sourceRoot.val > targetRoot.val) sourceRoot.parent = targetRoot;
        else targetRoot.parent = sourceRoot;
        return true;
    }
}
