package com.graph.traversal;

import com.graph.Node;
import com.visualization.VisualizationUtils;
import org.algorithm_visualizer.Array1DTracer;
import org.algorithm_visualizer.Commander;
import org.algorithm_visualizer.GraphTracer;
import org.algorithm_visualizer.Layout;
import org.algorithm_visualizer.Tracer;
import org.algorithm_visualizer.VerticalLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
    private static GraphTracer graphTracer = new GraphTracer("original graph");
    private static GraphTracer clonedGraphTracer = new GraphTracer("cloned graph");
    private static Array1DTracer visitedTracer = new Array1DTracer("visited");
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> nodes = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(node);
        Node head = null;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            nodes.putIfAbsent(cur.val, new Node(cur.val));
            Node clonedNode = nodes.get(cur.val);
            visited.add(cur.val);
            VisualizationUtils.configureSet(visitedTracer, visited);
            Tracer.delay();
            List<Node> neighbors = new ArrayList<>();
            for (Node neighbour : cur.neighbors) {
                if (neighbour != null) {
                    nodes.putIfAbsent(neighbour.val, new Node(neighbour.val));
                    neighbors.add(nodes.get(neighbour.val));
                    if (!visited.contains(neighbour.val)) {
                        queue.add(neighbour);
                    }
                }
            }
            clonedNode.neighbors = neighbors;
            if (head == null) {
                head = clonedNode;
            }
        }

        return head;
    }

    // constraint:
    // 1. node.val is unique
    // 2. no repeated edges and no self-loops in the graph.
    // a -> b, c, d
    // b -> a, c, d
    public static Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();
        return cloneGraphDFS(node, map);
    }

    private static Node cloneGraphDFS(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node cloned = new Node(node.val);
        map.put(node.val, cloned);

        for(Node neighbor : node.neighbors) {
            cloned.neighbors.add(cloneGraphDFS(neighbor, map));
        }


        return cloned;
    }

    public static Node cloneGraph3(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            map.putIfAbsent(cur.val, new Node(cur.val));
            Node cloned = map.get(cur.val);

            for(Node next : cur.neighbors) {
                if (!map.containsKey(next.val)) {
                    Node clonedNext = new Node(next.val);
                    map.put(next.val, clonedNext);
                    queue.offer(next);
                }
                cloned.neighbors.add(map.get(next.val));
            }


        }


        return map.get(node.val);
    }

    Map<Node, Node> copy = new HashMap<>();
    Set<Node> visited = new HashSet<>();
    public Node cloneGraph4(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.contains(node)) {
            return copy.get(node);
        }

        if (!copy.containsKey(node)) {
            visited.add(node);
            copy.put(node, new Node(node.val));
        }

        Node copied = copy.get(node);
        if (node.neighbors != null) {
            copied.neighbors = new ArrayList<>();

            for(Node neighbour : node.neighbors) {
                copied.neighbors.add(cloneGraph4(neighbour));
            }
        }


        return copied;
    }

    public Node cloneGraph5(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> copied = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node original = queue.poll();
            visited.add(original);
            copied.putIfAbsent(original, new Node(original.val));
            Node copiedNode = copied.get(original);

            if (original.neighbors != null) {
                copiedNode.neighbors = new ArrayList<>();

                for(Node neighbor : original.neighbors) {
                    copied.putIfAbsent(neighbor, new Node(neighbor.val));
                    copiedNode.neighbors.add(copied.get(neighbor));

                    if(!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }

            }

        }


        return copied.get(node);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));

        Layout.setRoot(new VerticalLayout(new Commander[]{graphTracer, clonedGraphTracer, visitedTracer}));
        graphTracer.directed(false);
        VisualizationUtils.configureGraphTracerByGraph(graphTracer, node1);
        Tracer.delay();
        Node clonedGraph = cloneGraph(node1);
        clonedGraphTracer.directed(false);
        VisualizationUtils.configureGraphTracerByGraph(clonedGraphTracer, clonedGraph);
        Tracer.delay();
    }
}
