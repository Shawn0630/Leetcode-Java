package com.dynamic_programming;

public class MaximumPointsYouCanObtainfromCards {
    Integer[][][] dp;
    public int maxScore(int[] cardPoints, int k) {
        dp = new Integer[cardPoints.length][cardPoints.length][k + 1];
        return maxScore(cardPoints, 0, cardPoints.length - 1, k);
    }

    private int maxScore(int[] cardPoints, int start, int end, int k) {
        if (start > end || k == 0) {
            return 0;
        }

        if (dp[start][end][k] != null) {
            return dp[start][end][k];
        }
        dp[start][end][k] =  Math.max(maxScore(cardPoints, start + 1, end , k - 1) + cardPoints[start], maxScore(cardPoints, start, end - 1, k - 1) + cardPoints[end]);
        return dp[start][end][k];
    }


    public int maxScore2(int[] cardPoints, int k) {
        int sum = 0;

        for(int i = 0; i < cardPoints.length && i < k; i++) {
            sum += cardPoints[i];
        }

        int max = sum;
        int front = k - 1;
        int back = cardPoints.length - 1;
        while (front < back && front >= 0) {
            sum = sum - cardPoints[front] + cardPoints[back];
            front--;
            back--;
            max = Math.max(max, sum);
        }

        return max;
    }
}
