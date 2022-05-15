package com.dynamic_programming;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class PartitionEqualSubsetSum {
    // https://hillzhang1999.gitee.io/2020/05/26/dong-tai-gui-hua-jing-dian-wen-ti-bei-bao-jiu-jiang-zheng-li/
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }


       return dp[target];
    }


    Boolean[][] dp;
    public boolean canPartitionDFS(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        dp = new Boolean[nums.length][target + 1];

        return canPartitionDFS(nums, 0, target);
    }

    private boolean canPartitionDFS(int[] nums, int current, int remain) {
        if (current >= nums.length) {
            return remain == 0;
        } else if (remain < 0) {
            return false;
        } else if (remain == 0) {
            return true;
        } else {
            if (dp[current][remain] != null) {
                return dp[current][remain];
            } else {
                dp[current][remain] = canPartitionDFS(nums, current + 1, remain - nums[current]) || canPartitionDFS(nums, current + 1, remain);
                return dp[current][remain];
            }
        }
    }

    Boolean[][] dp2;
    public boolean canPartition2(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        } else {
            int target = sum / 2;
            dp2 = new Boolean[nums.length][target + 1];
            return canPartition(nums, 0, target);
        }

    }

    private boolean canPartition(int[] nums, int index, int remaining) {

        if (remaining < 0) {
            return false;
        }
        if (remaining == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (dp2[index][remaining] != null) {
            return dp2[index][remaining];
        }

        dp2[index][remaining] = canPartition(nums, index + 1, remaining) || canPartition(nums, index + 1, remaining - nums[index]);
        return dp2[index][remaining];
    }
}
