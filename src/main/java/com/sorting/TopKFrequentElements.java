package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    // frequency range from [1 ... nums.length]
    // use a map to store the num with frequency
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        int[] ans = new int[nums.length];
        int idx = 0;
        for(int num : nums) {
            if (!freqMap.containsKey(num)) {
                ans[idx++] = num;
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return topK(Arrays.copyOf(ans, idx), freqMap, k);
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        int[] ans = new int[nums.length];
        int idx = 0;
        for(int num : nums) {
            if (!freqMap.containsKey(num)) {
                ans[idx++] = num;
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return topK(Arrays.copyOf(ans, idx), freqMap, k);
    }

    private int[] topK(int[] nums, Map<Integer, Integer> freq, int k) {
        // sort until find the correct location of k - 1
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pos = quickSelct(nums, left, right, freq);
            if (pos == k - 1) {
                break;
            } else if (pos > k - 1){
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }

        return k > nums.length ? nums : Arrays.copyOf(nums, k);
    }

    // return the proper index of pivot
    // 4    1   2   5   6 => xx  xx(larger)   4   xx xx(smaller)
    // pivot 4
    // find the first element smaller than pivot left
    // find the first element greater than pivot from right
    private int quickSelct(int[] nums, int left, int right, Map<Integer, Integer> freq) {
        int pivotIndex = left;
        int pivot = freq.get(nums[left]);
        while (left <= right) {
            while (left <= right && pivot <= freq.get(nums[left]))left++;
            while (left <= right && pivot >= freq.get(nums[right]))right--;
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, pivotIndex, right);

        return right;
    }

    private void swap(int[] nums, int a, int b) {
        if (a < 0 || a >= nums.length || b < 0 || b >= nums.length) {
            return;
        }

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] ans = new int[nums.length];
        int idx = 0;
        for(int num : nums) {
            if (!freq.containsKey(num)) {
                ans[idx++] = num;
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return topK3(Arrays.copyOf(ans, idx), k, freq);
    }

    private int[] topK3(int[] nums, int k, Map<Integer, Integer> freq) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pos = quickSelect3(nums, left, right, freq);
            if (pos == k - 1) {
                break;
            } else if (pos > k - 1){
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }

        return Arrays.copyOf(nums, k);
    }

    private int quickSelect3(int[] nums, int left, int right, Map<Integer, Integer> freq) {
        int pivotIndex = left;
        int pivot = nums[left];

        // freq.get(left) > freq.get(pivot) > freq.get(right)
        while (left <= right) {
            while (left <= right && freq.get(nums[left]) >= freq.get(pivot)) left++;
            while (left <= right && freq.get(nums[right]) <= freq.get(pivot)) right--;
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, pivotIndex, right);

        return right;
    }

    public int[] topKFrequent4(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] ans = new int[nums.length];
        int idx = 0;
        for(int num : nums) {
            if (!freq.containsKey(num)) {
                ans[idx++] = num;
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return topK3(Arrays.copyOf(ans, idx), k, freq);
    }

    private int[] topK3(int[] nums, Map<Integer, Integer> freq, int k) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int index = quickSelect(start, end, nums, freq);
            if (index == k - 1) {
                break;
            } else if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }

        return Arrays.copyOf(nums, k);
    }

    private int quickSelect(int start, int end, int[] nums, Map<Integer, Integer> freq) {
        int pivotIndex = start;
        int pivot = freq.get(nums[start]);

        // nums[start] ..>.. nums[index] ..>. nums[end]
        while (start <= end) {
            while (start <= end && freq.get(nums[start]) >= pivot) start++;
            while (start <= end && freq.get((nums[end])) <= pivot) end--;
            if (start < end) {
                swap(nums, start, end);
            }
        }

        swap(nums, pivotIndex, end);

        return end;
    }
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent3(new int[]{1,1,1,2,2,3}, 2);
    }
}
