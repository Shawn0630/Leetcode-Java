package com.tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ValidateBinaryTreeNodes {
    // 4
    //[1,-1,3,-1]
    //[2,3,-1,-1]

    //          0
    //      1        2
    //          3
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.size() != 1) {
            return false;
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited.contains(node)) {
                return false;
            }
            visited.add(node);
            if (leftChild[node] != -1)  {
                queue.offer(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                queue.offer(rightChild[node]);
            }
        }

        return visited.size() == n;
    }
}
