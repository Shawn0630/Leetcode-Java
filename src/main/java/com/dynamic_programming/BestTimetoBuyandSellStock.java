package com.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestTimetoBuyandSellStock {
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;

        for(int i = 1; i < prices.length; i++) {
            if (prices[i - 1] >= prices[i]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = prices[i] - prices[i - 1] + dp[i - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int profix : dp) {
            if (max < profix) {
                max = profix;
            }
        }

        return max;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;

        for(int i = 1; i < prices.length; i++) {
           dp[i] = Math.max(0, dp[i - 1] + prices[i] - prices[i - 1]);
        }

        int max = Integer.MIN_VALUE;
        for(int profit : dp) {
            max = Math.max(max, profit);
        }

        return max;
    }

    public int maxProfit3(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][prices.length + 1];

        for(int i = 0; i <= prices.length; i++) {
            dp[0][i] = 0;
        }
        for(int i = 0; i < 2; i++) {
            dp[0][i] = 0;
        }

        if (k > prices.length / 2) {
            int profit = 0;
            for(int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        for(int i = 1; i <= k; i++) {
            int maxDiff = Integer.MIN_VALUE;
            dp[0][1] = 0;
            for(int j = 2; j <= prices.length; j++) {
// o(k * n^2) solution
//                int maxProfit = 0;
//                for(int t = 0; t < j; t++) {
//                    maxProfit = Math.max(maxProfit, dp[i - 1][t] + prices[j - 1] - prices[t]);
//                }
//                dp[i][j] = Math.max(dp[i][j - 1], maxProfit);

                maxDiff = Math.max(maxDiff, dp[0][j - 2] - prices[j - 2]);
                dp[1][j] = Math.max(dp[1][j - 1], maxDiff + prices[j - 1]);
            }
            dp[0] = Arrays.copyOf(dp[1], prices.length + 1);
        }

        return dp[1][prices.length];
    }


    public int maxProfit32(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length == 0) {
            return 0;
        }

        if (k >=  prices.length / 2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k + 1][prices.length];
        for(int i = 1; i < dp.length; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }

        return dp[k][prices.length - 1];
    }

    public int maxProfit4(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

       int[] buyHere = new int[prices.length]; // last action is buy
       int[] sellHere = new int[prices.length]; // last action is sell

       buyHere[0] = -prices[0];
       sellHere[0] = 0;
       for(int i = 1; i < prices.length; i++) {
           buyHere[i] = Math.max(buyHere[i - 1], i >= 2 ? sellHere[i - 2] - prices[i] : -prices[i]);
           sellHere[i] = Math.max(sellHere[i - 1], buyHere[i - 1] + prices[i]);
       }


       return sellHere[prices.length - 1];
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0; // sell
        dp[0][1] = -prices[0]; // buy

        for(int i = 1; i < prices.length; i++) {
           dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
           dp[i][0] = Math.max(dp[i - 1][1] + prices[i] - fee, dp[i - 1][0]);
        }

        return dp[prices.length - 1][0];
    }
}
