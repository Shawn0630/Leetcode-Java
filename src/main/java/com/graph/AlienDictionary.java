package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

    // constraints/assumptions
    // 1. no empty list, or null list
    // 2. string consists of lower case letter only
    // https://leetcode.com/problems/alien-dictionary/discuss/70207/Clarification-about-prefix-problem.-%22abc%22-and-%22ab%22
    public String alienOrder(String[] words) {
        boolean[][] nextChar = new boolean[26][26];
        Set<Integer> alphabet = new HashSet<>();
        int[] indegree = new int[26];

        for(String word: words) {
            for(char c : word.toCharArray()) {
                alphabet.add(c - 'a');
            }
        }

        for(int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];

            for(int j = 0; j < Math.min(prev.length(), cur.length()); j++) {
                char prevChar = prev.charAt(j);
                char curChar = cur.charAt(j);
                if (prevChar != curChar) {
                    nextChar[prevChar - 'a'][curChar - 'a'] = true;
                    break;
                }
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();


        for(int i = 0; i < nextChar.length; i++) {
            for(int j = 0; j < nextChar.length; j++) {
                if (nextChar[i][j]) {
                    indegree[j]++;
                }
            }
        }

        for(int c : alphabet) {
            if (indegree[c] == 0) {
                queue.offer(c);
                visited.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append((char)(cur + 'a'));

            for(int i = 0; i < nextChar[cur].length; i++) {
                    if (nextChar[cur][i]) {
                        indegree[i]--;
                        if (indegree[i] == 0 && !visited.contains(i)) {
                            visited.add(i);
                            queue.offer(i);
                        }
                    }
                }
        }

        return sb.length() == alphabet.size() ? sb.toString() : "";
    }

    public static void  main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
//        alienDictionary.alienOrder(new String[] {"wrt","wrf","er","ett","rftt"});
//        alienDictionary.alienOrder(new String[] {"abc", "ab"});
        alienDictionary.alienOrder2(new String[]{"ac","ab","zc","zb"});
    }

    public String alienOrder2(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>(); // a
        Set<Character> alphbet = new HashSet<>();

        for(String word: words) {
            for(char c : word.toCharArray()) {
                alphbet.add(c);
            }
        }
        for(int i = 1; i < words.length; i++) {
            String a = words[i - 1];
            String b = words[i];

            for(int j = 0; j < Math.min(a.length(), b.length()); j++) {
                char ac = a.charAt(j);
                char bc = b.charAt(j);

                if (ac != bc) {
                    map.putIfAbsent(ac, new HashSet<>());
                    map.get(ac).add(bc);
                    break;
                }
            }
        }

        Map<Character, Integer> visited = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(Character c : alphbet) {
            if (visited.getOrDefault(c, 0) == 0 && !dfs(map, c, visited, sb)) {
                return "";
            }
        }

        return sb.reverse().toString();
    }

    private boolean dfs(Map<Character, Set<Character>> map, Character c, Map<Character, Integer> visited, StringBuilder sb) {

        Set<Character> adjs = map.getOrDefault(c, new HashSet<>());

        visited.put(c, 1);
        for(Character adj : adjs) {
            if (visited.getOrDefault(adj, 0) == 0) {
                if (!dfs(map, adj, visited, sb)) return false;
            } else if (visited.getOrDefault(adj, 0) == 1) {
                return false;  // loop
            }
        }

        visited.put(c, 2);
        sb.append(c);
        return true;
    }
}
