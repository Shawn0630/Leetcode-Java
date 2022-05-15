package com.search;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthSmallestPairDistance {
    //[1, 3, 1], 1
    //[1, 1, 3] (0, 1) = (1, 2) < (0, 2)

    // assuming the following
    // 1. nums is not a null
    // 2. nums size >= 2

    // range [0, nums[i - 1] - nums[0]]
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); // [2, 1, 4, 3] => [1, 2, 3, 4]
        // 1 2 3 4 k = 3 => 3
        // 1 => 1 2 => 1 2 3 => (1) 2 3 4
        // 1 => 2 1 => 3 2 1 => (4) 3 2 1
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                queue.offer(nums[j] - nums[i]);

                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        return queue.isEmpty() ? -1 : queue.poll();
    }


    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums); // [2, 1, 4, 3] => [1, 2, 3, 4]
        int low = 0, high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            for(int i = 0; i < nums.length - 1; i++) {
                for(int j = i + 1; j < nums.length; j++) {
                    if (nums[j] - nums[i] > mid) break;
                    count++;
                }
            }

            // pitfall, this is not element find
            if (count == k) {
                return mid;
            } else if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return -1;
    }
}
