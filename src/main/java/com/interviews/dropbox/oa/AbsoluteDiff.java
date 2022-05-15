package com.interviews.dropbox.oa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class AbsoluteDiff {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public String[] absDiff(String str) {
        String[] strings = str.split(" ");
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((a, b) -> {
            int adiff = diff(a);
            int bdiff = diff(b);

            if (adiff != bdiff) {
                return adiff - bdiff;
            } else {
                return a.compareTo(b);
            }
        });

        for(String s : strings) {
            priorityQueue.offer(s);
        }

        String[] ans = new String[strings.length];
        int idx = 0;
        while (!priorityQueue.isEmpty()) {
            ans[idx++] = priorityQueue.poll();
        }

        return ans;
    }

    private int diff(String s) {
        char[] sc = s.toCharArray();
        int vowelCount = 0;
        int nonVowelCount = 0;

        for(char c : sc) {
            if (vowels.contains(c)) {
                vowelCount++;
            } else {
                nonVowelCount++;
            }
        }

        return Math.abs(vowelCount - nonVowelCount);
    }

    public static void main(String[] args) {
        AbsoluteDiff absoluteDiff = new AbsoluteDiff();
        String input = "people lives in hawaii";
        String[] output = absoluteDiff.absDiff(input);
        for(String s : output) {
            System.out.print(s + " ");
        }
    }
}
