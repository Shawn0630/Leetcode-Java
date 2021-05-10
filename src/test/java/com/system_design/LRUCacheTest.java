package com.system_design;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LRUCacheTest {
    @Test
    public void test1() {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1), is(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        assertThat(cache.get(2), is(-1));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        assertThat(cache.get(1), is(-1));       // returns -1 (not found)
        assertThat(cache.get(3), is(3));       // returns 3
        assertThat(cache.get(4), is(4));       // returns 4
    }

    @Test
    public void test2() {
        LRUCache cache = new LRUCache( 1 /* capacity */ );

        cache.put(2, 1);
        assertThat(cache.get(2), is(1));       // returns 1
        cache.put(3, 2);    // evicts key 2
        assertThat(cache.get(2), is(-1));       // returns -1 (not found)
        assertThat(cache.get(3), is(2));       // returns 3
    }

}
