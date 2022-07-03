package com.interviews.dropbox.ID_generator;

public interface IDGenerator {
    // Constraints/Restrictions
    // 1. in-memory Vs. on-disk, file system or db
    // 2. Single Server Vs. Distributed ID generator, TPS
    // 3. Auto-Incrementing IDs Vs Hashing/Encoding based
    public int allocate();
    public void release(int id);
    public boolean check(int id);
}
