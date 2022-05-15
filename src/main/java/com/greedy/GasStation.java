package com.greedy;

public class GasStation {

    // gas = [1,2,3,4,5], cost = [3,4,5,1,2]

    //          0       1       2       3       4
    //cost      3       4       5       1       2
    //gas       1       2       3       4       5
    //gap       -1      -1      -1      -1      4
    //o(n2)

    // https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas.

    // unique => the first one I found is the correct one
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int curTank = 0;
        int totalTank = 0;
        for(int i = 0; i < gas.length; i++) {
           curTank += (gas[i] - cost[i]);
           totalTank += (gas[i] - cost[i]);

           if (curTank < 0) {
               start = i + 1; // start ~ [0, gas.length + 1]
               curTank = 0;
           }
        }

        return totalTank < 0 ? -1 : start;
    }
}
