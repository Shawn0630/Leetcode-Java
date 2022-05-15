package com.system_design;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import javafx.util.Pair;

public class NestedIterator implements Iterator<Integer> {


      public interface NestedInteger {

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          Integer getInteger();

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          List<NestedInteger> getList();
      }

//    private Deque<NestedInteger> deque;
//
//
//    // [[[[]]]]
//    public NestedIterator(List<NestedInteger> nestedList) {
//        this.deque = new ArrayDeque<>();
//        for(NestedInteger nestedInteger : nestedList) {
//            deque.addLast(nestedInteger);
//        }
//    }
//
//    @Override
//    public Integer next() {
//      moveIntegerToTop();
//      return deque.pollFirst().getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        moveIntegerToTop();
//        return !deque.isEmpty();
//    }
//
//    private void moveIntegerToTop() {
//        if (!deque.isEmpty()) {
//            while (deque.peekFirst() != null && !deque.peekFirst().isInteger()) {
//                NestedInteger nestedInteger = deque.pollFirst();
//                List<NestedInteger> nestedIntegerList = nestedInteger.getList();
//                for(int i = nestedIntegerList.size() - 1; i >=0; i--) {
//                    deque.addFirst(nestedIntegerList.get(i));
//                }
//            }
//        }
//    }

    // [1,[2,3]]
    // [[]]
    Deque<NestedInteger> deque;
    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new LinkedList<>();
        for(NestedInteger nestedInteger : nestedList) {
            List<NestedInteger> nestedIntegers = offer(nestedInteger);
            for(NestedInteger nest : nestedIntegers) {
                deque.offerLast(nest);
            }

        }
    }

    @Override
    public Integer next() {
        NestedInteger nestedInteger = deque.pollFirst();
        return nestedInteger.getInteger();
    }

    private List<NestedInteger> offer(NestedInteger nestedInteger) {
        List<NestedInteger> list = new ArrayList<>();
        if (nestedInteger.isInteger()) {
            return Arrays.asList(nestedInteger);
        } else {
            if (nestedInteger.getList() == null || nestedInteger.getList().size() == 0) {
                return new ArrayList<>();
            }
            for(NestedInteger nested : nestedInteger.getList()) {
                list.addAll(offer(nested));
            }
        }
        return list;
    }

    @Override
    public boolean hasNext() { // hasNext should contains the most logic, call hasNext on next function
        return !deque.isEmpty();
    }
}
