package com.interviews.dropbox.ID_generator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class QueueIDGenerator implements IDGenerator {

    Queue<Integer> available;
    Set<Integer> used;
    int MAX_SIZE;

    public QueueIDGenerator(int maxSize) {
        available = new LinkedList<>();
        used = new HashSet<>();
        this.MAX_SIZE = maxSize;

        for(int i = 0; i < maxSize; i++) {
            available.offer(i);
        }
    }

    @Override
    public int allocate() {
        if (!available.isEmpty()) {
            int id = available.poll();
            used.add(id);

            return id;
        }

        return -1;
    }

    @Override
    public void release(int id) {
        if (!check(id)) {
            used.remove(id);
            available.offer(id);
        }
    }

    @Override
    public boolean check(int id) {
        return !used.contains(id);
    }
}
