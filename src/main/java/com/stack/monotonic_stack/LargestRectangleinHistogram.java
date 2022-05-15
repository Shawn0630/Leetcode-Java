package com.stack.monotonic_stack;

import java.util.Stack;

public class LargestRectangleinHistogram {
    // [2,1,2]
    // [9,0]
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallerIndexOnRight = new int[heights.length];

        for(int i = heights.length - 1; i >= 0; i--) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            nextSmallerIndexOnRight[i] = stack.empty() ? heights.length : stack.peek();
            stack.push(i);// height[i] > stack.peek();
        }

        stack = new Stack<>();
        int[] nextSmallerIndexOnLeft = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            nextSmallerIndexOnLeft[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);// height[i] > stack.peek();
        }

        int largestRectangle = 0;
        for(int i = 0; i < heights.length; i++) {
            largestRectangle = Math.max(heights[i] * (nextSmallerIndexOnRight[i] - nextSmallerIndexOnLeft[i] - 1), largestRectangle);
        }

        return largestRectangle;
    }


    //       0       1       2       3       4           5
    //      [2,      1,      5,      6,      2,          3]
    //       2     1 * 6     5       6       2 * (4 - 2 + 5 - 4 + 1)
    //  L    -1       -1     1       2       1           4
    //  R    1       -1      4       4       -1          -1

    //       0      1
    //      [2,     4]
    // L     0      0
    // R     0      1

    //      2 * (0 - 0 - 1

    //       0      1
    //      [9,     0]
    // L     -1     -1
    // R     1      2
    // 9 * (0 - -1 -1 + 1 + 1 - 0 - 1) = 9
    public static int largestRectangleArea2(int[] heights) { //next smaller on left and right
        Stack<Integer> stack = new Stack<>();
        int[] nextSmallerOnRight = new int[heights.length];
        int[] nextSmallerOnLeft = new int[heights.length];

        for(int i = heights.length - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) { // heights[stack.peek] < height[i]
                stack.pop();
            }
            if (!stack.empty()) {
                nextSmallerOnRight[i] = stack.peek();
            } else {
                nextSmallerOnRight[i] = heights.length;
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) { // heights[stack.peek] < height[i]
                stack.pop();
            }
            if (!stack.empty()) {
                nextSmallerOnLeft[i] = stack.peek();
            } else {
                nextSmallerOnLeft[i] = -1;
            }
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++) {
            int area = heights[i] * (i - nextSmallerOnLeft[i] - 1 + 1 + nextSmallerOnRight[i] - i - 1);
            max = Math.max(area, max);
        }

        return max;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{9, 0});
    }
}
