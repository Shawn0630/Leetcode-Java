package com.array.two_pointers;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length && fast >= 0) {

            int nextIndex = nextIndex(nums, fast);
            if (nextIndex < 0 || nextIndex >= nums.length) {
                return false;
            }
            fast = nextIndex(nums, nextIndex);
            slow = nextIndex(nums, slow);

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, int cur) {
        if (nums[cur] > 0) {
            return cur + 1;
        } else if (nums[cur] < 0) {
            return cur - 1;
        } else {
            return cur;
        }
    }
}
