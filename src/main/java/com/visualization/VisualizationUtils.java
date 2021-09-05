package com.visualization;

import com.graph.Node;
import com.tree.TreeNode;
import org.algorithm_visualizer.Array1DTracer;
import org.algorithm_visualizer.GraphTracer;

import java.awt.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class VisualizationUtils {
    private static String VISUALIZATION_URL = "http://192.168.0.19:8088/api/visualizations";
    public static void setEnv(String key, String value) {
        try {
            Map<String, String> env = System.getenv();
            Class<?> cl = env.getClass();
            Field field = cl.getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map<String, String>) field.get(env);
            writableEnv.put(key, value);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to set environment variable", e);
        }
    }

    public static void configureGraphTracerByBinaryTree(GraphTracer tracer, TreeNode root) {
        if (tracer != null && root != null) {
            tracer.addNode(root.val);
            if (root.left != null) {
                configureGraphTracerByBinaryTree(tracer, root.left);
                tracer.addEdge(root.val, root.left.val);
            }
            if (root.right != null) {
                configureGraphTracerByBinaryTree(tracer, root.right);
                tracer.addEdge(root.val, root.right.val);
            }
        }
    }

    public static void configureGraphTracerByGraph(GraphTracer tracer, Node node) {
        if(tracer != null && node != null) {
            Set<Integer> visited = new HashSet<>();
            cloneGraphDFS(tracer, node, visited);
        }
    }

    public static void configureSet(Array1DTracer tracer, Set<Integer> set) {
        if (tracer != null && set != null) {
            tracer.set(new ArrayList<>(set));
        }
    }

    private static void cloneGraphDFS(GraphTracer tracer, Node node, Set<Integer> visited) {
        visited.add(node.val);
        tracer.addNode(node.val);
        List<Node> neighbours = node.neighbors;
        for (Node neighbour : neighbours) {
            if (neighbour != null) {
                tracer.addEdge(node.val, neighbour.val);
                if (!visited.contains(neighbour.val)) {
                    cloneGraphDFS(tracer, neighbour, visited);
                }
            }
        }
    }
}
