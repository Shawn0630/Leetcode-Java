package com.system_design;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextElement;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = nextElement;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}
