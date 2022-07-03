package com.interviews.dropbox.Id_generator;

import com.interviews.dropbox.ID_generator.HeapBitSetIDGenerator;
import com.interviews.dropbox.ID_generator.IDGenerator;

public class HeapBitsetGeneratorTest extends IDGeneratorTest {
    @Override
    IDGenerator getIDGenerator(int maxRange) {
        return new HeapBitSetIDGenerator(maxRange);
    }
}
