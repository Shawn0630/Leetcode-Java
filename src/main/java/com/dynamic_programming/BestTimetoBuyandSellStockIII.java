package com.dynamic_programming;

public class BestTimetoBuyandSellStockIII {
    // https://medium.com/@USTCLink/秒杀面试中的股票问题-看这一篇就够了-fa730ae4681d
    public static int maxProfit(int[] prices) {
        // [1,2,3,4,5]
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 0 buy 1 sell
        int[][][] dp = new int[prices.length][2][2];

        dp[0][0][0] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][0][1] = -prices[0];// IMPORTANT, otherwise WA in [1, 2, 3, 4, 5]
        dp[0][1][1] = 0;

        for(int i = 1; i < prices.length; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] + prices[i]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] + prices[i]);
        }

        return Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][1][1]);
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1, 2, 3, 4, 5});

    }
}
