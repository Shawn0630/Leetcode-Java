package com.dynamic_programming;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    Boolean[][][] dp;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        dp = new Boolean[heights.length][bricks + 1][ladders + 1];
        for(int i = heights.length - 1; i >= 0; i--) {
            if (furthestBuilding(heights, i, bricks, ladders)) {
                return i;
            }
        }

        return 0;
    }

    private boolean furthestBuilding(int[] heights, int index, int bricks, int ladders) {
        if (index == 0) {
            return true;
        }
        if (dp[index][bricks][ladders] != null) {
            return dp[index][bricks][ladders];
        }
        if (heights[index - 1] >= heights[index]) {
            dp[index][bricks][ladders] = furthestBuilding(heights, index - 1, bricks, ladders);;
            return dp[index][bricks][ladders];
        }
        boolean enoughBricks = bricks >= (heights[index] - heights[index - 1]);
        boolean enoughLadder = ladders >= 1;

        if (!enoughBricks && !enoughLadder) {
            dp[index][bricks][ladders] = false;
            return dp[index][bricks][ladders];
        } else if (!enoughBricks) {
            dp[index][bricks][ladders] = furthestBuilding(heights, index - 1, bricks, ladders - 1);
            return dp[index][bricks][ladders];
        } else if (!enoughLadder) {
            dp[index][bricks][ladders] = furthestBuilding(heights, index - 1, bricks - (heights[index] - heights[index - 1]), ladders);
            return dp[index][bricks][ladders];
        } else {
            dp[index][bricks][ladders] = furthestBuilding(heights, index - 1, bricks, ladders - 1) ||
                    furthestBuilding(heights, index - 1, bricks - (heights[index] - heights[index - 1]), ladders);
            return dp[index][bricks][ladders];
        }
    }
    // either ladder or bricks, but don't know which one use ladder, which one use bricks
    // https://leetcode.com/problems/furthest-building-you-can-reach/discuss/2176828/Java-or-Greedy-or-Explained
    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int usedBrick = 0;
        for(int i = 1; i < heights.length; i++) {
            if (heights[i - 1] >= heights[i]) continue;
            priorityQueue.offer(heights[i] - heights[i - 1]);
            if(priorityQueue.size() > ladders) {
                usedBrick += priorityQueue.poll();
            }
            if (usedBrick > bricks) {
                return i - 1;
            }
        }
        return heights.length - 1;
    }

}
