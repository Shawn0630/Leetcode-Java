package com.interviews.dropbox.ID_generator;

import java.util.BitSet;

public class HeapBitSetIDGenerator implements IDGenerator {
    BitSet bitset;
    private static int MAX_ID;

    //           0
    //      1           2
    //  3       4

    public HeapBitSetIDGenerator(int maxId) {
        MAX_ID = maxId;
        bitset = new BitSet(maxId * 2 - 1);
    }

    @Override
    public int allocate() {
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
        updateTree2(index);

        return index - MAX_ID + 1;
    }

    @Override
    public void release(int id) {
        if (!check(id)) {
            int index = id + MAX_ID - 1;
            bitset.clear(index);
            updateTree2(index);
        }

    }

    @Override
    public boolean check(int id) {
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

    // 5 elements
    //                      0
    //          1                       2
    //      3        4              5       6
    //  7       8  9
    // elements index starts from 5
    //

    // 0 - 5
    // 0 + 5 - 1

    private int parent(int idx) {
        if (idx < 0 || idx >= 2 * MAX_ID - 1) {
            return -1;
        }

        return (idx - 1) / 2;
    }

    private void updateTree2(int idx) {
        while (idx > 0) {
            int parent = parent(idx);
            if (idx % 2 == 0) { // rightChild
                if (bitset.get(idx) && bitset.get(idx - 1)) {
                    bitset.set(parent);
                } else {
                    bitset.clear(parent);
                }
            } else { // leftChild
                if (bitset.get(idx) && bitset.get(idx + 1)) {
                    bitset.set(parent);
                } else {
                    bitset.clear(parent);
                }
            }

            idx = parent;
        }
    }
}
