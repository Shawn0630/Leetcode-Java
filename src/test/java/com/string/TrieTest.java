package com.string;

import com.strings.Trie;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {

    @Test
    public void test1() {
        Trie trie = new Trie();

        trie.insert("apple");
        assertTrue(trie.search("apple"));   // returns true
        assertFalse(trie.search("app"));     // returns false
        assertTrue(trie.startsWith("app")); // returns true
        trie.insert("app");
        assertTrue(trie.search("app"));     // returns true
    }
}
