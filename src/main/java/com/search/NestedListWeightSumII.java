package com.search;

import java.util.List;

public class NestedListWeightSumII {
    public interface NestedInteger {
//      // Constructor initializes an empty nested list.
//          public NestedInteger();
//
//          // Constructor initializes a single integer.
//          public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    // [[1,1],2,[1,1]]
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int max = Integer.MIN_VALUE;
        for(NestedInteger nestedInteger : nestedList) {
            max = Math.max(maxDepth(nestedInteger, 1), max);
        }

        int sum = 0;
        for(NestedInteger nestedInteger : nestedList) {
            sum += depthSumInverse(nestedInteger, 1, max);
        }

        return sum;
    }

    private int depthSumInverse(NestedInteger nestedInteger, int depth, int maxDepth) {
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * (maxDepth - depth + 1);
        } else {
            int sum = 0;
            for(NestedInteger integer : nestedInteger.getList()) {
                sum += depthSumInverse(integer, depth + 1, maxDepth);
            }
            return sum;
        }
    }

    private int maxDepth(NestedInteger integer, int depth) {
        if (integer.isInteger()) {
            return depth;
        } else {
            int max = Integer.MIN_VALUE;
            for(NestedInteger nestedInteger : integer.getList()) {
                max = Math.max(maxDepth(nestedInteger, depth + 1), max);
            }
            return max;
        }
    }
}
