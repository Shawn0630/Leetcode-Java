package com.interviews.dropbox.ID_generator;

import java.util.BitSet;

public class HeapBitSetIDGenerator implements IDGenerator<Integer, Integer> {
    BitSet bitset;
    private static int MAX_ID;

    //           0
    //      1           2
    //  3       4

    public HeapBitSetIDGenerator(int maxId) {
        MAX_ID = maxId;
        bitset = new BitSet(maxId * 2 + 1);
    }

    @Override
    public Integer allocate() {
        int index = 0;
        while (index < MAX_ID - 1) { // 2 < 2
            if (!bitset.get(index * 2 + 1)) {
                index = index * 2 + 1;
            } else if (!bitset.get(index * 2 + 2)) {
                index = index * 2 + 2;
            } else {
                return -1;
            }
        }

        bitset.set(index);
        updateTree(index);

        return index - MAX_ID + 1;
    }

    @Override
    public void release(Integer id) {
        if (check(id)) {
            int index = id + MAX_ID - 1;
            bitset.clear(index);
            updateTree(index);
        }

    }

    @Override
    public boolean check(Integer id) {
        if (id < 0 || id >= MAX_ID) return false;
        return !bitset.get(id + MAX_ID - 1);
    }

    private void updateTree(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (idx % 2 == 1) { // left
                if (bitset.get(idx) && bitset.get(idx + 1)) {
                    bitset.set(parent);
                } else {
                    bitset.clear(parent);
                }
            } else { // right
                if (bitset.get(idx) && bitset.get(idx - 1)) {
                    bitset.set(parent);
                } else {
                    bitset.clear(parent);
                }
            }

            idx = parent;
        }
    }
}
