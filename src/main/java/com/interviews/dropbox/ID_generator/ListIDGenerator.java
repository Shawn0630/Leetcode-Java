package com.interviews.dropbox.ID_generator;

import java.util.BitSet;

public class ListIDGenerator implements IDGenerator<Integer, Integer> {
    @Override
    public Integer allocate() {
        return 0;
    }

    @Override
    public void release(Integer id) {

    }

    @Override
    public boolean check(Integer id) {
        return false;
    }


    public static void main(String[] args)
    {
        String blogName = "howtodoinjava.com";

        System.out.println( blogName.hashCode() );

        System.out.println( "howtodoinjava.com".hashCode() );
    }
}
