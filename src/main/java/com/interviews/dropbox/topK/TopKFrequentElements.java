package com.interviews.dropbox.topK;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    // 4 2 1 3
    // 4 -> 2, 4 -> {1}, 2, 4
    // 4 -> 4, 2 -> 4, 2, 1
    public int[] topKFrequent(int[] nums, int k) {
        int[] topKs = new int[k];
        Map<Integer, Integer> freqCounts = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(freqCounts::get));
        for(int num : nums) {
            freqCounts.put(num, freqCounts.getOrDefault(num, 0) + 1);
            // 2, 4
            // 2(3), 4(4)
            // 1(3)
            if (priorityQueue.size() < k || freqCounts.get(num) >= freqCounts.get(priorityQueue.peek())) {
                priorityQueue.remove(num);
                priorityQueue.offer(num);

                if (priorityQueue.size() >= k) {
                    priorityQueue.poll();
                }
            }
        }

        int idx = 0;
        while (!priorityQueue.isEmpty()) {
            topKs[idx++] = priorityQueue.poll();
        }

        return Arrays.copyOf(topKs, k);
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] freq = new int[nums.length];
        int idx = 0;
        for(int num : nums) {
            if (!freqMap.containsKey(num)) {
                freq[idx++] = num;
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return quickSelect(Arrays.copyOf(freq, idx), k, freqMap);
    }

    private int[] quickSelect(int[] nums, int k, Map<Integer, Integer> freqMap) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int index = quickSelect(nums, left, right, freqMap);
            if (index == k - 1) {
                return Arrays.copyOf(nums, k);
            } else if (index < k - 1) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }

        return Arrays.copyOf(nums, k);
    }

    private int quickSelect(int[] nums, int left, int right, Map<Integer, Integer> freqMap) {
        int pivot = freqMap.get(nums[left]);
        int pivotIndex = left;

        // left > pivot > right
        while (left <= right) {
            while (left <= right && freqMap.get(nums[left]) >= pivot) left++;
            while (left <= right && freqMap.get(nums[right]) <= pivot) right--;

            if (left < right) {
                swap(nums, left, right);
            }
        }
        if (right != pivotIndex) {
            swap(nums, right, pivotIndex);
        }

        return right;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] input = new int[]{3, 0, 1, 0};
        int[] output = topKFrequentElements.topKFrequent2(input, 2);

    }
}
