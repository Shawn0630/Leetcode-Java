package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    // hit cog
    // ["hot","dot","dog","lot","log","cog"]
    // unique ? lower case only?
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();

        wordList.add(beginWord);
        for(int i = 0; i < wordList.size(); i++) {
            for(int j = i + 1; j < wordList.size(); j++) {
                String source = wordList.get(i);
                String target = wordList.get(j);
                if(isOneDiff(wordList.get(i), wordList.get(j))) {
                    map.putIfAbsent(source, new ArrayList<>());
                    map.putIfAbsent(target, new ArrayList<>());

                    map.get(source).add(target);
                    map.get(target).add(source);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int counter = 1;

        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            List<String> nexts = new ArrayList<>();
            int size = queue.size();

            while (size > 0) {
                nexts.add(queue.poll());
                size--;
            }

            for(String next : nexts) {
                if (next.equals(endWord)) {
                    return counter;
                }
                visited.add(next);
                List<String> words = map.get(next);
                if (words != null) {
                    for (String word : words) {
                        if (!visited.contains(word)) {
                            queue.offer(word);
                        }
                    }
                }
            }
            counter++;
        }

        return 0;
    }


    // abc acc => return true
    // abc acd => return false
    private boolean isOneDiff(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        return count == 1;
    }


    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        wordLadder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }
}
