package com.graph;

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
