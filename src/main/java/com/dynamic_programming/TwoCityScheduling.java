package com.dynamic_programming;

public class TwoCityScheduling {

    Integer[][][] dp;
    // https://leetcode.com/problems/two-city-scheduling/discuss/670713/3-ways-C%2B%2B-Greedy-%2B-DP-%2B-step-by-step-template
    public int twoCitySchedCost(int[][] costs) {
        dp = new Integer[costs.length][costs.length / 2 + 1][costs.length / 2 + 1];
        return twoCityScheduleCost(costs, 0, costs.length / 2, costs.length / 2);
    }

    // remain spot at A

    private int twoCityScheduleCost(int[][] costs, int cur, int aremain, int bremain) {
        if (cur >= costs.length) {
            return 0;
        }
        if (aremain == 0 && bremain == 0) {
            return 0;
        }
        if (dp[cur][aremain][bremain] != null) {
            return dp[cur][aremain][bremain];
        }
        if (aremain == 0) {
            dp[cur][aremain][bremain] = twoCityScheduleCost(costs, cur + 1, 0, bremain - 1) + costs[cur][1];
        } else if (bremain == 0) {
            dp[cur][aremain][bremain] =  twoCityScheduleCost(costs, cur + 1, aremain - 1, 0) + costs[cur][0];
        } else {
            dp[cur][aremain][bremain] =  Math.min(twoCityScheduleCost(costs, cur + 1, aremain - 1, bremain) + costs[cur][0],
                    twoCityScheduleCost(costs, cur + 1, aremain, bremain - 1) + costs[cur][1]);
        }

        return dp[cur][aremain][bremain];
    }

    Integer[][] dp2;
    public int twoCitySchedCost2(int[][] costs) {
        dp2 = new Integer[costs.length][costs.length / 2 + 1];
        twoCitySchedCost2(costs, 0, costs.length / 2);

        return dp2[0][costs.length / 2];
    }

    private int twoCitySchedCost2(int[][] costs, int cur, int aremain) {
        if (cur >= costs.length) {
            return 0;
        }

        if (dp2[cur][aremain] != null) {
            return dp2[cur][aremain];
        }
        if (aremain == 0) {
            dp2[cur][aremain] = twoCitySchedCost2(costs, cur + 1, 0) + costs[cur][1];// not equals
        } else {
            if (twoCitySchedCost2(costs, cur + 1, aremain - 1) + costs[cur][0] <
            twoCitySchedCost2(costs, cur + 1, aremain) + costs[cur][1]) {
                System.out.println("cur = " + cur + " pick " + 0);
            } else {
                System.out.println("cur = " + cur + " pick " + 1);
            }
            dp2[cur][aremain] = Math.min(twoCitySchedCost2(costs, cur + 1, aremain - 1) + costs[cur][0],
                    twoCitySchedCost2(costs, cur + 1, aremain) + costs[cur][1]);
        }

        return dp2[cur][aremain];
    }

    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        twoCityScheduling.twoCitySchedCost2(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}});
    }
}
