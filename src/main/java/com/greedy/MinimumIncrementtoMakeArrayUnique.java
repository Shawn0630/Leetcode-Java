package com.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumIncrementtoMakeArrayUnique {

    // LTE
    public int minIncrementForUnique(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);

        for(int num : nums) {
            queue.offer(num);
        }

        int operations = 0;
        while (!queue.isEmpty()) {
            int f = queue.poll();
            if (!queue.isEmpty() && queue.contains(f)) {
                f = f + 1;
                operations++;

                queue.offer(f);
            }
        }


        return operations;
    }

    public int minIncrementForUnique2(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        Arrays.sort(nums);

        int operation = 0;
        for(int num : nums) {
            while (seen.contains(num)) { // while loop => math calculations
                num++;
                operation++;
            }
            seen.add(num);
        }


        return operation;
    }


    // nextAvailable
    public int minIncrementForUnique3(int[] nums) {

        Arrays.sort(nums);

        int operation = 0;
        int nextAvailable = nums[0] + 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                operation += (nextAvailable - nums[i]);
                nums[i] = nextAvailable;
                nextAvailable++;
            } else {
                nextAvailable = Math.max(nextAvailable + 1, nums[i] + 1);
            }
        }


        return operation;
    }

}
