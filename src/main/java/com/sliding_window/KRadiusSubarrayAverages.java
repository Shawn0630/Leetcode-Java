package com.sliding_window;

public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int left = 0;
        int right = k;

        int idx = 0;
        int[] avgs = new int[nums.length];
        long sum = 0;
        if (k <= nums.length) {
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
        }
        while (right < nums.length) {
            sum += nums[right];
            if (right - left < 2 * k) {
                avgs[idx++] = -1;
            } else {
                avgs[idx++] = (int)sum / (2 * k + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        for(int i = idx; i < nums.length; i++) {
            avgs[i] = -1;
        }

        return avgs;
    }

    // presum
}
