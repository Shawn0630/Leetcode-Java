package com.search;

import java.util.List;

public class NestedListWeightSum {
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

     // The depth of an integer is the number of lists that it is inside of.
    public int depthSum(List<NestedInteger> nestedList) {
         int sum = 0;
         for(NestedInteger nestedInteger : nestedList) {
            sum += depthSum(nestedInteger, 1);
         }

         return sum;
    }

    private int depthSum(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * depth;
        } else { // list
            int sum = 0;
            for(NestedInteger integer : nestedInteger.getList()) {
                sum += depthSum(integer, depth + 1);
            }
            return sum;
        }
    }
}
