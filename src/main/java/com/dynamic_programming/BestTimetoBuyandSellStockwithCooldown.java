package com.dynamic_programming;

public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 0 buy 1 sell 2 hold
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return dp[prices.length - 1][1];
    }
}
