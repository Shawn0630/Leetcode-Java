package com.system_design;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

class Twitter {

    // https://leetcode.com/problems/design-twitter/discuss/1435996/Java-HashMap-%2B-PriorityQueue-Solution
    // https://leetcode.com/problems/design-twitter/discuss/1309255/Java-OOD-with-TreeMap-and-HashMap
    Map<Integer, List<Integer>> followers;
    Map<Integer, List<Tweet>> tweets;
    Map<Integer, Queue<Tweet>> tweetOf;
    int timeStamp;
    /** Initialize your data structure here. */
    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        tweetOf = new HashMap<>();
        timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        initIfnotExist(userId);

        List<Integer> followersOf = followers.get(userId);
        Tweet tweet = new Tweet(tweetId, userId, timeStamp++);
        tweetOf.get(userId).add(tweet);
        tweets.get(userId).add(tweet);
        for (Integer follower : followersOf) {
            tweets.get(follower).add(tweet);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!tweets.containsKey(userId)) {
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(11, Comparator.comparingInt(a -> a.timeStamp));
        List<Tweet> list = tweets.get(userId);

        for(Tweet t : list) {
            priorityQueue.add(t);
            if (priorityQueue.size() > 10) {
                priorityQueue.poll();
            }
        }

        List<Integer> feeds = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            feeds.add(priorityQueue.poll().id);
        }

        Collections.reverse(feeds);

        return feeds;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        initIfnotExist(followerId);
        initIfnotExist(followeeId);

        List<Integer> followersOf = followers.get(followeeId);
        if (!followersOf.contains(followerId) && followeeId != followerId) {
            followers.get(followeeId).add(followerId);
            Queue<Tweet> tweetList = tweetOf.get(followeeId);
            for (Tweet t : tweetList) {
                tweets.get(followerId).add(t);
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        initIfnotExist(followerId);
        initIfnotExist(followeeId);

        List<Integer> followersOf = followers.get(followeeId);
        if (followersOf.contains(followerId) && followeeId != followerId) {
            followersOf.remove(followersOf.indexOf(followerId));
            Queue<Tweet> tweetList = tweetOf.get(followeeId);
            for(Tweet t : tweetList) {
                tweets.get(followerId).remove(t);
            }
        }
    }

    private void initIfnotExist(int userId) {
        if (!followers.containsKey(userId)) {
            followers.put(userId, new ArrayList<>());
            tweets.put(userId, new ArrayList<>());
            tweetOf.put(userId, new ArrayDeque<>());
        }

    }

    private class Tweet {
        public int id;
        public int author;
        public int timeStamp;
        Tweet(int id, int author, int timeStamp) {
            this.id = id;
            this.author = author;
            this.timeStamp = timeStamp;
        }
    }
}

