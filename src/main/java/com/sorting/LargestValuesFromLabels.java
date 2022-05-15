package com.sorting;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestValuesFromLabels {
    // https://leetcode.com/discuss/interview-question/306851
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        //        1 2 3  k = 2  expected keep 2 3
        // min  1 => 1 2 => (1) 2 3
        for(int i = 0; i < values.length; i++) {
            map.putIfAbsent(labels[i], new PriorityQueue<>());
            map.get(labels[i]).offer(values[i]);

            if (map.get(labels[i]).size() > useLimit) {
                map.get(labels[i]).poll();
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(PriorityQueue<Integer> q : map.values()) {
            while (!q.isEmpty()) {
                queue.offer(q.poll());
                if (queue.size() > numWanted) {
                    queue.poll();
                }
            }
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }

        return sum;
    }

    public int largestValsFromLabels2(int[] values, int[] labels, int numWanted, int useLimit) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < values.length; i++) {
            map.putIfAbsent(labels[i], new ArrayList<>());
            map.get(labels[i]).add(values[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(List<Integer> value : map.values()) {
            list.addAll(topK(value, useLimit));
        }


        int sum = 0;
        for(int value : topK(list, numWanted)) {
            sum += value;
        }

        return sum;
    }

    private List<Integer> topK(List<Integer> list, int k) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int index = partition(list, left, right);
            if (index == k - 1) break;
            else if (index > k - 1) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return k >= list.size() ? list.subList(0, list.size()) : list.subList(0, k);
    }


    // 2    1   3   5   4
    // pivot    left
    private int partition(List<Integer> list, int start, int end) {
        int pivot = list.get(start);
        int left = start, right = end;

        while (left <= right) {
            while (left <= right && list.get(left) >= pivot) left++;
            while (left <= right && list.get(right) <= pivot) right--;
            if (left < right) {
                swap(list, left, right);
            }
        }

        swap(list, start, right);

        return right;
    }

    private void swap(List<Integer> list, int i, int j) {
        if (i < 0 || i >= list.size() || j < 0 || j >= list.size()) {
            return;
        }

        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
