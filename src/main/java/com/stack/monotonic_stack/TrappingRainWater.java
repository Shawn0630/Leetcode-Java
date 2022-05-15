package com.stack.monotonic_stack;

import java.util.Stack;

public class TrappingRainWater {
    // [0,  1,0,2,1,0,1,3,2,1,2,1]
    //                              -

    //  0   1  2
    //  [1, 0, 2]   => 1
    //  [2, 2  -1]


    // [4, 3, 2, 1, 5]
    //           --
    // -- 1  1  1
    //   --  1  1
    //      --  1
    //         --
    //
    //

    // 2   0  2
    // [2] [2] [-1]
    // [-1][0] [-1]
    // --
    //     1    --
    //     1
    //     -- --


    //    0   1   2   3   4   5   6   7   8   9   10  11
    //   [0,  1,  0,  2,  1,  0,  1,  3,  2,  1,  2,  1]
    // L  -1  -1  1   -1  3   4   4   -1  7   8   8   10
    // R  1   3   3   7   6   6   7   -1  10  10  -1  -1
    //    s   s   1   s
    //                    --
    //        -- 1  1  1     --  1  --
    //    -- 1   -- 1  --      --     --
    //  --  --      --


    //      0   1   2  3
    //      2   0   1  3
    // L    -1  0   0  -1
    // R     3  2   3   -1
    //          Math.min(a[2], a[0]) - a[1] = 2 - 0 = 2
    //              Math.min(a[3], a[0]) - a[2] = 2 - 1 = 1
    //           --
    //  --  1  1
    //      1 --
    //     --
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int[] nextGreaterR = new int[height.length];
        int[] nextGreaterL = new int[height.length];

        //next greater element
        for(int i = height.length - 1; i >= 0; i--) {
            while (!stack.empty() && height[stack.peek()] < height[i]) stack.pop(); // stack.peek() >= height[i]
            if (!stack.empty()) {
                nextGreaterR[i] = stack.peek();
            } else {
                nextGreaterR[i] = -1;
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek()] < height[i]) stack.pop(); // stack.peek() >= height[i]
            if (!stack.empty()) {
                nextGreaterL[i] = stack.peek();
            } else {
                nextGreaterL[i] = -1;
            }
            stack.push(i);
        }

        int sum = 0;
        for(int i = 0; i < nextGreaterR.length; i++) {
            if (nextGreaterR[i] != -1 && nextGreaterL[i] != -1) {
                sum += (Math.min(height[nextGreaterR[i]], height[nextGreaterL[i]]) - height[i]);
            }
        }

        return sum;
    }

    //      [0,     1,      0,      2,      1,      0,      1,      3,      2,      1,      2,      1]
    // 3                                                            1
    // 2                            1                                       1               1
    // 1            1                       1               1                       1               1
    // 0     1              1                       1
    //                      1               1       2       1               1       2       1       2
    public int trap2(int[] height) {
        int[] leftLargest = new int[height.length];
        int[] rightLargest = new int[height.length];

        leftLargest[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            leftLargest[i] = Math.max(leftLargest[i - 1], height[i]);
        }

        rightLargest[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--) {
            rightLargest[i] = Math.max(rightLargest[i + 1], height[i]);
        }

        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            sum += Math.min(leftLargest[i], rightLargest[i]) - height[i];
        }

        return sum;
    }


    //                 -
    //          -
    // -    -       -
    //    -
    //

    //       0   1   2   3   4   5   6   7   8   9   10  11
    //      [0,  1,  0,  2,  1,  0,  1,  3,  2,  1,  2,  1]
    //
    // 3                                 -
    // 2                -                    -       -
    // 1         -          -       -           -        -
    // 0    -       -            -
    //              1

    public static void main(String[] arg) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        trappingRainWater.trap(new int[]{2, 0, 1, 3});
    }
}
