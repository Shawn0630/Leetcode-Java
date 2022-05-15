package com.interviews.dropbox.ID_generator;

public class HashIDGenerator implements IDGenerator<Object, String> {
    @Override
    public String allocate(Object object) {
        return null;
    }

    @Override
    public String allocate() {
        return null;
    }

    @Override
    public boolean check(String id) {
        return false;
    }

    @Override
    public void release(String id) {

    }
}
