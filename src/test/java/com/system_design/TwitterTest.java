package com.system_design;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TwitterTest {
    @Test
    public void test1() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        assertThat(twitter.getNewsFeed(1), is(Arrays.asList(5)));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        assertThat(twitter.getNewsFeed(1), is(Arrays.asList(6, 5)));
        twitter.unfollow(1, 2);
        assertThat(twitter.getNewsFeed(1), is(Arrays.asList(5)));
    }

    @Test
    public void test2() {
        Twitter twitter = new Twitter();
        twitter.postTweet(2, 5);
        twitter.follow(1, 2);
        twitter.follow(1, 2);
        assertThat(twitter.getNewsFeed(1), is(Arrays.asList(5)));
    }

    @Test
    public void test3() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        assertThat(twitter.getNewsFeed(1), is(Arrays.asList(333,505,94,2,10,13,101,3,5)));
    }
}
