package com.interviews.dropbox;

import java.util.BitSet;

public class PhoneDirectory {
    private final int max;
    private BitSet bitSet;
    public PhoneDirectory(int max) {
        this.max = max;
        bitSet = new BitSet(2 * max);
    }


    // 1 2 3
    //              0
    //       1                2
    //   3      4       5

    //          0
    //      1       2
    //  3

    //                      0
    //            1                      2
    //      3           4           5       6
    //  7       8   9       10  11      12

    public int get() {
        int i = 0;
        if (bitSet.get(0)) {
            return -1;
        }
        while (i < max) {
            if (!bitSet.get( 2 * i + 1)) {
                i = i * 2 + 1;
            } else if (!bitSet.get(2 * i + 2)){
                i = i * 2 + 2;
            } else {
                return -1;
            }
        }

        bitSet.set(i);
        update(i);
        return i - max;
    }

    public void release(int id) {
        int start = id + max;
        bitSet.clear(start);
        update(start);
    }

    public boolean check(int id) {
        return !bitSet.get(id + max);
    }


    private void update(int n) {
        while (n > 0) {
            int parent = (n - 1) / 2;
            if (n % 2 == 0) { // rightChild
                if (bitSet.get(n) && bitSet.get(n - 1)) {
                    bitSet.set(parent);
                } else {
                    bitSet.clear(parent);
                }
            } else { // leftChild
                if (bitSet.get(n) && (n + 1 > 2 * max - 1 || bitSet.get(n + 1))) {
                    bitSet.set(parent);
                } else {
                    bitSet.clear(parent);
                }
            }
            n = parent;
        }
    }

    public static void main(String args[]) {
        PhoneDirectory phoneDirectory = new PhoneDirectory(1);
        phoneDirectory.get();
        phoneDirectory.get();
    }
}
