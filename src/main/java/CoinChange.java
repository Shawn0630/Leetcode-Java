public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] min = new int[amount + 1];

        min[0] = 0;
        for(int i = 1; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= amount; i++) {
//            if (min[i] != 1) {
//                min[i] = Integer.MAX_VALUE;
//                for (int j = i - 1; j > 0; j--) {
//                    if (min[j] != Integer.MAX_VALUE && min[i - j] != Integer.MAX_VALUE) {
//                        min[i] = Math.min(min[i], min[j] + min[i - j]);
//                    }
//                }
//            }
            for(int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && min[i - coins[j]] != Integer.MAX_VALUE) {
                    min[i] = Math.min(min[i], min[i - coins[j]] + 1);
                }
            }
        }

        return min[amount] == Integer.MAX_VALUE ? -1 : min[amount];

    }


    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int[] count = new int[amount + 1];

        count[0] = 1;
        for(int i = 1; i < count.length; i++) {
            count[i] = 0;
        }
        for(int i = 0; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
               if (count[i] > 0) {
                   if (i + coins[j] <= amount) {
                       count[i + coins[j]] += count[i];
                   }
               }
            }
        }

        return count[amount];
    }

//    public int change(int amount, int[] coins) {
//        int [] dp = new int [amount+1];
//        dp[0] = 1;
//        for(int coin: coins) {
//            for(int i = coin; i <= amount ; i++) {
//                dp[i] += dp[i - coin];
//            }
//        }
//
//        return dp[amount];
//
//
//    }
}
