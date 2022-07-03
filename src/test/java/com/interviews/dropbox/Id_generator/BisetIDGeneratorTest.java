package com.interviews.dropbox.Id_generator;

import com.interviews.dropbox.ID_generator.BitSetIDGenerator;
import com.interviews.dropbox.ID_generator.IDGenerator;

public class BisetIDGeneratorTest extends IDGeneratorTest {

    @Override
    IDGenerator getIDGenerator(int maxRange) {
        return new BitSetIDGenerator(maxRange);
    }
}
