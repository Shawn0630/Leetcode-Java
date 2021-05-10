package com.linked_list;

import java.util.LinkedList;

public class RecentCounter {

    private LinkedList<Integer> slidingWindow;

    public RecentCounter() {

        slidingWindow = new LinkedList<>();
    }

    public int ping(int t) {

        slidingWindow.add(t);

        while (slidingWindow.getFirst() < t - 3000) slidingWindow.removeFirst();

        return slidingWindow.size();
    }
}
