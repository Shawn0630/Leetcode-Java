package com.search.binary_search;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int left = min, right = max;

        // the first element with count of greater element larger than k
        // 1    2   3   4   5   k = 1
        // 0
        while (left < right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            for(int num : nums) {
                if (num > mid) count++;
            }

            if (count >= k) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

    public int findKthSmallest(int[] nums, int k) {
        // ans range from min to max, sorted
        //
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int left = min, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getCount(nums, mid); // count of num smaller or equals to i;
            if (count < (k + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        return left;
    }

    //  1   2   4   5
    //  1   2   4   5
    //  1   2(3)    4   5

    //  1   (2)  3  (4)  5
    private int getCount(int[] nums, int num) {
        int counter = 0;

        for(int i : nums) {
            if (num <= i) {
                counter++;
            }
        }

        return counter;
    }


    // https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/1966195/binary-search-solution-C%2B%2B
    // https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/1917248/FASTEST-SOLution
    public int findKthLargest2(int[] nums, int k) {
        // ans range from min to max, sorted
        //
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int left = min, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getLargeCount(nums, mid); // count of num greater or equals to i;
            if (count <= k - 1) {
                right = mid; // the first k - 1
            } else {
                left = mid + 1;
            }
        }


        return left;
    }

    //  1   2   4   5
    //  1   2   4   5
    //  1   2(3)    4   5

    //  1   (2 - 2)  3 - 2  (4 - 1)  5 - 1
    //  l                            r
    //               m
    //                         l
    //                         lr
    //      2 - 2
    //      3 - 2
    //      4 - 1


    // 1 (2) 3 (4) 5
    // 5 - 0    1
    // 4 - 1    1
    // 3 - 1    2
    // 2 - 2    2
    // 1 - 2    3
    // absent value have difference output with existing values
    private int getLargeCount(int[] nums, int num) {
        int counter = 0;

        for(int i : nums) {
            if (i > num) {
                counter++;
            }
        }

        return counter;
    }
}
