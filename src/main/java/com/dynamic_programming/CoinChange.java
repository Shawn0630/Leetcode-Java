package com.dynamic_programming;

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

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChangeDFS(new int[]{1, 2, 5}, 100));
    }
}
