package com.dynamic_programming;

public class MinimumCostForTickets {
    // https://leetcode.com/problems/minimum-cost-for-tickets/discuss/630868/explanation-from-someone-who-took-2-hours-to-solve
    Integer[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[days.length];
        return minCost(days, 0, costs);
    }

    private int minCost(int[] days, int current, int[] cost) {
        if (current >= days.length) {
            return 0;
        } else if (dp[current] != null) {
            return dp[current];
        }

        int pass1 = cost[0] + minCost(days, current + 1, cost);

        int next = current;
        for(; next < days.length; next++) {
            if (days[next] - days[current] >= 7) break;
        }
        int pass7 = cost[1] + minCost(days, next, cost);
        next = current;
        for(; next < days.length; next++) {
            if (days[next] - days[current] >= 30) break;
        }
        int pass30 = cost[2] + minCost(days, next, cost);

        dp[current] = Math.min(pass1, Math.min(pass7, pass30));
        return dp[current];
    }
}
