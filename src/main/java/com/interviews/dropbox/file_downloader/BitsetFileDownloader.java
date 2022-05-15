package com.interviews.dropbox.file_downloader;

import java.util.BitSet;

public class BitsetFileDownloader implements StreamFileDownloader {
    BitSet bitSet;
    int size;

    public BitsetFileDownloader(int size) {
        this.size = size;
        bitSet = new BitSet(size);
    }

    @Override
    public boolean isFileDone() {
        return bitSet.cardinality() == this.size;
    }

    @Override
    public void addBlock(Chuck chuck) {
        bitSet.set(chuck.start, chuck.end);
    }
}
