package com.interviews.dropbox.ID_generator;

import java.util.BitSet;

public class BitSetIDGenerator implements IDGenerator {
    BitSet bitSet;

    private static int MAX_ID;
    private int nextAvailable;

    public BitSetIDGenerator(int maxId) {
        MAX_ID = maxId;
        this.bitSet = new BitSet(MAX_ID);
        this.nextAvailable = 0;
    }
    @Override
    public int allocate() {
        if (nextAvailable >= MAX_ID) return -1;
        int num = nextAvailable;
        bitSet.set(num);
        nextAvailable = bitSet.nextClearBit(num); // o(n)

        return num;
    }

    @Override
    public void release(int id) {
        if (id < 0 || id >= MAX_ID) return;
        if(bitSet.get(id)) {
            bitSet.clear(id);
            nextAvailable = Math.min(nextAvailable, id);
        }

    }

    // allocate 0 1 2
    // release 1
    // release 2
    // 1 ...

    @Override
    public boolean check(int id) {
        if (id < 0 || id >= MAX_ID) return false;
        return !bitSet.get(id);
    }
}
