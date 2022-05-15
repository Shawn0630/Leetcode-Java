package com.system_design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleanArray {
    int[] nums;
    Random random;
    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(this.nums, this.nums.length);

        for(int i = 0; i < shuffled.length; i++) {
            int to = randRange(i, this.nums.length);
            swap(shuffled, i, to);
        }

        return shuffled;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
