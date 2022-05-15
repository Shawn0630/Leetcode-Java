package com.array;

public class ContainerWithMostWater {
    //  0   1   2   3   4   5   6   7   8
    // [1,  8,  6,  2,  5,  4,  8,  3,  7]
    //  l                               r
    //      l                           r
    //      l                       r
    //
    // Math.min(height[l], height[r]) * (r - l)
    // （r - l) decreasing
    // Math.min increasing
    // https://leetcode.com/problems/container-with-most-water/discuss/200246/Proof-by-formula


    // height = [1,8,6,2,5,4,8,3,7]
    // ans = Math.min(height[i], height[j]) * (j - i)
    // naive approach i ~ [0, n - 1], j ~ [i + 1, n - 1]
    // ai < aj no need to check j - 1, j - 2 .... i, check i + 1, i + 2.... j
    // ai >= aj no need to check i + 1, i + 2 ... j, check j - 1, j - 2 ...i
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        int maxArea = Integer.MIN_VALUE;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else if (height[l] > height[r]) {
                r--;
            } else {
                l++;
                r--;
            }
        }

        return maxArea;
    }

    //  0   1   2   3   4   5   6   7   8
    // [1,  8,  6,  2,  5,  4,  8,  3,  7]
    // area = Math.min(a[i], a[j]) * (j - i)
    // (j - i) decreasing
    // Math.min(a[i], a[j]) increasing
    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;

        int maxArea = Integer.MIN_VALUE;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else if (height[l] > height[r]) {
                r--;
            } else {
                l++;
                r--;
            }
        }

        return maxArea;
    }
}
