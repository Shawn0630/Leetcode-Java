package com.search;

public class CoinChange2 {
    // [1,  2,  5]  5
    // [2]          3
    public int change(int amount, int[] coins) {
        return dfs(amount, coins, 0);
    }

    public int dfs(int remaining, int[] coins, int cur) {
        if (remaining < 0 || remaining > 0 && cur >= coins.length) {
            return 0;
        } else if(remaining == 0) {
            return 1;
        } else {
            return dfs(remaining - coins[cur], coins, cur) + dfs(remaining, coins, cur + 1);
        }
    }
}
