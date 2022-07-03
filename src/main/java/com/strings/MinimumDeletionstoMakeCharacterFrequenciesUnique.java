package com.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int[] freq = new int[26];

        Arrays.fill(freq, 0);

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // [1,1] => [1, 0]
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for(int f : freq) {
            if (f != 0) {
                queue.offer(f);
            }
        }

        //[3, 3, 2, 2]
        //[2, 3, 2, 2]
        //[3, 2, 2, 2]
        //[3, 1, 2, 2]
        //[3, 1, 1, 1]

        int operations = 0;
        while (!queue.isEmpty()) {
            int f = queue.poll();
            if (!queue.isEmpty() && queue.contains(f)) {
                f = f - 1;
                operations++;
                if (f > 0) {
                    queue.offer(f);
                }
            }
        }


        return operations;
    }


    public static void main(String args[]) {
        MinimumDeletionstoMakeCharacterFrequenciesUnique minimumDeletionstoMakeCharacterFrequenciesUnique = new MinimumDeletionstoMakeCharacterFrequenciesUnique();
        minimumDeletionstoMakeCharacterFrequenciesUnique.minDeletions("aaabbbcc");
    }
}
