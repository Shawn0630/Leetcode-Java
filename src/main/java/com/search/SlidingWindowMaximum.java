package com.search;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            return null;
        }

        int left = 0;
        int right = 0;
        int[] ans = new int[nums.length - k +  1];
        ans[0] = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i]) stack.pop();
            if (stack.empty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = stack.peek(); // stack.peek > nums[i]
            }
            stack.push(i);
        }

        int idx = 0;
        int curMaxIndex = -1;
        while (right < nums.length) {
            if (right - left + 1 == k) {
                if (curMaxIndex != -1 && nums[curMaxIndex] <= nums[right]) {
                    curMaxIndex = right;
                } else {
                    if (curMaxIndex == -1 || curMaxIndex < left) curMaxIndex = left;
                    while (nextGreater[curMaxIndex] != -1 && nextGreater[curMaxIndex] <= right) {
                        curMaxIndex = nextGreater[curMaxIndex];
                    }
                }

                ans[idx++] = nums[curMaxIndex];
                left++;
            }
            right++;
        }

        return ans;
    }


    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();

        swm.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            return null;
        }

        int[] ans = new int[nums.length - k +  1];
        Integer[] numsInt = Arrays.stream( nums ).boxed().toArray( Integer[]::new );

        RMQ<Integer> rmq = new RMQ.RMQBuilder<Integer>()
                .withArray(numsInt)
                .build();

        for(int i = 0; i < ans.length; i++) {
            ans[i] = rmq.queryRangeMax(i, i + k - 1);
        }


        return ans;
    }

    public static class RMQ<T extends Comparable<T>> {
        private T[] array;
        private T[][] max;
        private T[][] min;

        // https://www.cnblogs.com/yoke/p/6949838.html
        // https://blog.csdn.net/alps1992/article/details/51440803
        protected RMQ(T[] array, T[][] max, T[][] min) {
            this.array = array;
            this.max = max;
            this.min = min;
        }

        public T queryRangeMax(int i, int j) {
            int z = log2(i, j);

            return max[i][z].compareTo(max[j - (1 << z) + 1][z]) < 0 ?
                    max[j - (1 << z) + 1][z] : max[i][z];
        }

        public T queryRangeMin(int i, int j) {
            int z = log2(i, j);

            return min[i][z].compareTo(min[j - (1 << z) + 1][z]) < 0 ?
                    min[i][z] : min[j - (1 << z) + 1][z];
        }

        protected boolean validate() {
            for(int i = 0; i < array.length - 1; i++) {
                for(int j = i + 1; j < array.length; j++) {
                    T[] subArray = Arrays.copyOfRange(array, i,j + 1);
                    if (queryRangeMin(i, j) != arrayMin(subArray)) {
                        return false;
                    }
                    if (queryRangeMax(i, j) != arrayMax(subArray)) {
                        return false;
                    }
                }
            }

            return true;
        }

        private T arrayMin(T[] array) {
            T min = array[0];
            for(T item : array) {
                if (min.compareTo(item) > 0) {
                    min = item;
                }
            }

            return min;
        }

        private T arrayMax(T[] array) {
            T max = array[0];
            for(T item : array) {
                if (max.compareTo(item) < 0) {
                    max = item;
                }
            }

            return max;
        }

        private int log2(int i, int j) {
            int z = 0;
            while ((1 << (z + 1)) <= j - i + 1) z++;

            return z;
        }


        public static class RMQBuilder<T extends Comparable<T>> {
            private T[] array;
            private int k = 20;

            public RMQBuilder<T> withArray(T[] array) {
                this.array = array;

                return this;
            }

            public RMQBuilder<T> withK(int k) {
                this.k = k;

                return this;
            }

            public RMQ<T> build() {
                T[][] min = (T[][]) new Comparable[array.length][k + 1];
                T[][] max = (T[][]) new Comparable[array.length][k + 1];

                for (int i = 0; i < array.length; i++)  {
                    max[i][0] = array[i];   // 先预处理2^0长度的
                    min[i][0] = array[i];
                }

                for (int j = 1; j < k; j++) {  // 这里j的范围根据具体题目数据定义
                    for (int i = 0; i + (1 << j) - 1 < array.length; i++) {    // num为数组内整数的个数
                        min[i][j] = min[i][j - 1].compareTo(min[i + (1 << (j - 1))][j - 1]) < 0 ? min[i][j - 1]: min[i + (1 << (j - 1))][j - 1];
                        max[i][j] = max[i][j - 1].compareTo(max[i + (1 << (j - 1))][j - 1]) > 0 ? max[i][j - 1]: max[i + (1 << (j - 1))][j - 1];
                    }
                }

                return new RMQ<>(array, max, min);
            }
        }

    }
}
