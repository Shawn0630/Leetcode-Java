package com.sliding_window;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class SubstringwithConcatenationofAllWordsTest {

    SubstringwithConcatenationofAllWords scal = new SubstringwithConcatenationofAllWords();

    @Test
    public void test1() {
        assertThat(scal.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}), containsInAnyOrder(0, 9));
        assertThat(scal.findSubString2("barfoothefoobarman", new String[]{"foo","bar"}), containsInAnyOrder(0, 9));
    }

    @Test
    public void test2() {
        assertThat(scal.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}), containsInAnyOrder(Collections.emptyList()));
        assertThat(scal.findSubString2("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}), containsInAnyOrder(Collections.emptyList()));
    }

    @Test
    public void test3() {
        assertThat(scal.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}), containsInAnyOrder(13));
        assertThat(scal.findSubString2("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}), containsInAnyOrder(13));
    }
}
