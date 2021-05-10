package com.system_design;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LFUCacheTest {


    @Test
    public void test1() {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1), is(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        assertThat(cache.get(2), is(-1));       // returns -1 (not found)
        assertThat(cache.get(3), is(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        assertThat(cache.get(1), is(-1));       // returns -1 (not found)
        assertThat(cache.get(3), is(3));       // returns 3
        assertThat(cache.get(4), is(4));       // returns 4
    }

    @Test
    public void test5() {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(1, 2);
        assertThat(cache.get(1), is(2));       // returns 1
        cache.put(2, 2);    // evicts key 2
        assertThat(cache.get(2), is(2));       // returns -1 (not found)
        assertThat(cache.get(3), is(-1));       // returns 3.
        cache.put(1, 3);    // evicts key 1.
        assertThat(cache.get(1), is(3));       // returns -1 (not found)
        assertThat(cache.get(2), is(2));       // returns 3
        assertThat(cache.get(3), is(-1));       // returns 4
    }

    @Test
    public void test2() {
        LRUCache cache = new LRUCache(1);

        cache.put(1, 1);
        assertThat(cache.get(1), is(1));
        cache.put(2, 2);
        assertThat(cache.get(2), is(2));
        cache.put(1, 2);
        assertThat(cache.get(1), is(2));
    }

    @Test
    public void test3() {
        LFUCache cache = new LFUCache(3);
        cache.put(2, 2);
        cache.put(1, 1);
        assertThat(cache.get(2), is(2));
        assertThat(cache.get(1), is(1));
        assertThat(cache.get(2), is(2));
        cache.put(3, 3);
        cache.put(4, 4);
        assertThat(cache.get(3), is(-1));
        assertThat(cache.get(2), is(2));
        assertThat(cache.get(1), is(1));
        assertThat(cache.get(4), is(4));
    }

    @Test
    public void test4() {
        LFUCache cache = new LFUCache(2);
        assertThat(cache.get(2), is(-1));
        cache.put(2, 6);
        assertThat(cache.get(1), is(-1));
        cache.put(1, 5);
        cache.put(1, 2);
        assertThat(cache.get(1), is(2));
        assertThat(cache.get(2), is(6));

    }
}
