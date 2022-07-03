package com.interviews.dropbox.Id_generator;

import com.interviews.dropbox.ID_generator.IDGenerator;
import com.interviews.dropbox.ID_generator.QueueIDGenerator;

class QueueIDGeneratorTest extends IDGeneratorTest {

    @Override
    IDGenerator getIDGenerator(int maxRange) {
        return new QueueIDGenerator(maxRange);
    }
}
