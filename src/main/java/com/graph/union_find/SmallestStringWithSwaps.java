package com.graph.union_find;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        UnionFind unionFind = new UnionFind(s.length());
        char[] cs = s.toCharArray();
        for(List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            int parent = unionFind.find(i);
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(i);
        }

        for(List<Integer> value : map.values()) {
            List<Character> characters = new ArrayList<>();
            for(Integer index : value) {
                characters.add(cs[index]);
            }
            characters.sort(Comparator.comparingInt(a -> a));

            for(int i = 0; i < value.size(); i++) {
                cs[value.get(i)] = characters.get(i);
            }
        }

        return String.valueOf(cs);

    }

    private class UnionFind {
        int n;
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n];
            this.size = new int[n];

            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean union(int i, int j) {
            int pi = find(i);
            int pj = find(j);

            if (pi == pj) return false;

            if (size[pi] > size[pj]) { // small tree to big tree
                parent[pj] = pi;
                size[pi] += size[pj];
            } else {
                parent[pi] = pj;
                size[pj] += size[pi];
            }

            return true;
        }

        public int find(int i) {
           if (parent[i] == i) return i;

           parent[i] = find(parent[i]);

           return parent[i];
        }
    }
}
