package com.interviews.dropbox.ID_generator;

public interface IDGenerator<T,Q> {
    // Constraints/Restrictions
    // 1. in-memory Vs. on-disk, file system or db
    // 2. Single Server Vs. Distributed ID generator, TPS
    // 3. Auto-Incrementing IDs Vs Hashing/Encoding based
    default Q allocate(T object) {
        return this.allocate();
    };
    public Q allocate();
    public void release(Q id);
    public boolean check(Q id);
}
