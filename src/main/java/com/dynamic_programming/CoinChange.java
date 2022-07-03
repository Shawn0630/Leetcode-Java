package com.dynamic_programming;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CoinChange {

    // https://leetcode.com/problems/coin-change/discuss/643896/A-discrete-dfs-solution-Java-3ms-98.84-greedy-approach
    // https://leetcode.com/problems/coin-change/discuss/77368/*Java*-Both-iterative-and-recursive-solutions-with-explanations
    // fewest number of coins
    public int coinChange(int[] coins, int amount) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        if (amount == 0) {
            return 0;
        }

        int count = 0;
        for(int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                queue.offer(amount - coins[i]);
                seen.add(amount - coins[i]);
            }
        }
        count++;

        while (!queue.isEmpty()) {
            List<Integer> remainings = new ArrayList<>();
            while (!queue.isEmpty()) {
                remainings.add(queue.poll());
            }
            for (Integer remaining : remainings) {
                if (remaining == 0) {
                    return count;
                }
                for(int i = 0; i < coins.length; i++) {
                    if (remaining - coins[i] >= 0 && !seen.contains(remaining - coins[i])) {
                        queue.offer(remaining - coins[i]);
                        seen.add(remaining - coins[i]);
                    }
                }
            }
            count++;
        }

        return -1;
    }


    Integer[] counts;
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        counts = new Integer[amount + 1];

        coinChangeDFS(coins, amount);

        return counts[amount];
    }

    private int coinChangeDFS(int[] coins, int remain) {
        if (remain < 0) {
            return -1;
        } else if (counts[remain] != null) {
            return counts[remain];
        } else if (remain == 0) {
            return 0;
        } else {
            int min = Integer.MAX_VALUE;
            for(int coin : coins) {
                int res = coinChangeDFS(coins, remain - coin);
                if (res != -1) {
                    min = Math.min(min, res + 1);
                }
            }

            counts[remain] = min == Integer.MAX_VALUE ? -1 : min;
            return counts[remain];
        }
    }


    Integer[][] dp;
    public int coinChange3(int[] coins, int amount) {
        Arrays.sort(coins);
        dp = new Integer[coins.length][amount + 1];

        return coinsChange3(coins, coins.length - 1, amount);
    }

    private int coinsChange3(int[] coins, int i, int amount) {
        if (i < 0 || amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (dp[i][amount] != null) {
            return dp[i][amount];
        }

        int keep = coinsChange3(coins, i, amount - coins[i]);
        int skip = coinsChange3(coins, i - 1, amount);
        if (keep == -1 && skip == -1) {
            dp[i][amount] = -1;
        } else if (keep == -1) {
            dp[i][amount] = skip;
        } else if (skip == -1) {
            dp[i][amount] = keep + 1;
        } else {
            dp[i][amount] = Math.min(skip, keep + 1);
        }
        // keep + skip
        return dp[i][amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChangeDFS(new int[]{1, 2, 5}, 100));
    }
}
