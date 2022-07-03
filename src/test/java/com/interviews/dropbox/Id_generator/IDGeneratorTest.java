package com.interviews.dropbox.Id_generator;

import com.interviews.dropbox.ID_generator.IDGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class IDGeneratorTest {
    abstract IDGenerator getIDGenerator(int maxRange);
    private final int MAX_RANGE = 100;

    @Test
    public void testAllocate() {
        IDGenerator idGenerator = getIDGenerator(MAX_RANGE);
        Set<Integer> used = new HashSet<>();
        for(int i = 0; i < MAX_RANGE; i++) {
            int id = idGenerator.allocate();
            assertNotEquals(-1, id);
            used.add(id);
        }
        for(int id : used) {
            assertFalse(idGenerator.check(id));
        }

        for(int i = 0; i < MAX_RANGE; i++) {
            int id = idGenerator.allocate();
            assertEquals(id, -1);
        }
    }

    @Test
    public void testRelease() {
        IDGenerator idGenerator = getIDGenerator(MAX_RANGE);
        Set<Integer> used = new HashSet<>();
        for(int i = 0; i < 0.5 * MAX_RANGE; i++) {
            int id = idGenerator.allocate();
            assertNotEquals(id, -1);
            used.add(id);
        }

        for(int id : used) {
            idGenerator.release(id);
            assertTrue(idGenerator.check(id));
        }
    }
}
