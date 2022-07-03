package com.interviews.dropbox.Id_generator;

import com.interviews.dropbox.ID_generator.HeapBitSetIDGenerator2;
import com.interviews.dropbox.ID_generator.IDGenerator;

public class HeapBitsetGenerator2Test extends IDGeneratorTest {
    @Override
    IDGenerator getIDGenerator(int maxRange) {
        return new HeapBitSetIDGenerator2(maxRange);
    }
}
