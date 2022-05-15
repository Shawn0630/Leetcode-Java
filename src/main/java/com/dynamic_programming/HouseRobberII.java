package com.dynamic_programming;

public class HouseRobberII {
    public int rob(int[] nums) {
        // https://leetcode.com/problems/house-robber-ii/discuss/1144311/Java-DP-Faster-than-100-or-no-additional-space-used
        // https://leetcode.com/problems/house-robber-ii/discuss/59934/Simple-AC-solution-in-Java-in-O(n)-with-explanation
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp0 = new int[nums.length][2]; // maximum amount at ith house, 0 - not rob, 1 - rob
        int[][] dp1 = new int[nums.length][2];

        dp0[0][0] = 0;
        dp0[0][1] = 0;
        dp1[0][0] = 0;
        dp1[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp0[i][1] = Math.max(dp0[i - 1][0] + nums[i], dp0[i - 1][1]);
            dp0[i][0] = Math.max(dp0[i - 1][0], dp0[i - 1][1]);
            dp1[i][1] = Math.max(dp1[i - 1][0] + nums[i], dp1[i - 1][1]);
            dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
        }


        return Math.max(nums.length - 2 < 0 ? nums[0] : dp1[nums.length - 2][1], dp0[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        houseRobberII.rob(new int[]{2, 3, 2});
    }
}
