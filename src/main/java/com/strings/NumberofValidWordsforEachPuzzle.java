package com.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/discuss/1486181/JAVA-EASY-BIT-MANIPULATION-SOLUTION
public class NumberofValidWordsforEachPuzzle {
    // TLE
    public List<Integer> findNumOfValidWordsLTE(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length == 0
            || puzzles == null || puzzles.length == 0) {
            return ans;
        }
        boolean[][] wordBuckets = new boolean[words.length][26];
        Map<Character, List<Integer>> wordMap = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            char[] wordChars = words[i].toCharArray();
            for (char aChar : wordChars) {
                if(!set.contains(aChar)) {
                    set.add(aChar);
                    wordBuckets[i][aChar - 'a'] = true;
                    wordMap.putIfAbsent(aChar, new ArrayList<>());
                    wordMap.get(aChar).add(i);
                }
            }

        }

        for (String puzzle : puzzles) {
            int count = 0;
            char[] puzzleChars = puzzle.toCharArray();
            boolean[] puzzleBucket = new boolean[26];

            for (char puzzleChar : puzzleChars) {
                puzzleBucket[puzzleChar - 'a'] = true;
            }
            List<Integer> wordIndexArray = wordMap.get(puzzleChars[0]);
            if (wordIndexArray != null) {
                for (Integer wordIndex : wordIndexArray) {
                    char[] wordArray = words[wordIndex].toCharArray();
                    if (!wordBuckets[wordIndex][puzzleChars[0] - 'a']) continue;
                    ;
                    boolean isValid = true;
                    for (char c : wordArray) {
                        if (!(wordBuckets[wordIndex][c - 'a'] && puzzleBucket[c - 'a'])) isValid = false;
                    }
                    if (isValid) count++;
                }
            }
            ans.add(count);
        }

        return ans;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length == 0
                || puzzles == null || puzzles.length == 0) {
            return ans;
        }
        int[] wordMask = new int[words.length];
        Map<Character, List<Integer>> wordMap = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            char[] wordChars = words[i].toCharArray();
            for (char aChar : wordChars) {
                if(!set.contains(aChar)) {
                    set.add(aChar);
                    wordMask[i] = wordMask[i] | (1 << (aChar - 'a'));
                    wordMap.putIfAbsent(aChar, new ArrayList<>());
                    wordMap.get(aChar).add(i);
                }
            }

        }

        for (String puzzle : puzzles) {
            int count = 0;
            char[] puzzleChars = puzzle.toCharArray();
            int puzzleMask = 0;

            for (char puzzleChar : puzzleChars) {
                puzzleMask = puzzleMask | (1 << puzzleChar - 'a');
            }
            List<Integer> wordIndexArray = wordMap.get(puzzleChars[0]);
            if (wordIndexArray != null) {
                for (Integer wordIndex : wordIndexArray) {
                    if ((puzzleMask & wordMask[wordIndex]) == wordMask[wordIndex]) count++;
                }
            }
            ans.add(count);
        }

        return ans;
    }

    private int getMask(String s){
        int m = 0 ;
        for(int i = 0 ;i < s.length(); i++){
            m |= 1 << (s.charAt(i) - 'a');
        }
        return m ;
    }

    // same mask between words and puzzles
    public List<Integer> findNumOfValidWordsFastest(String[] words, String[] puzzles) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> wmap = new HashMap<Integer, Integer>();
        for( int i = 0 ; i < words.length; i++) {
            int w = getMask(words[i]);
            wmap.put(w, wmap.getOrDefault(w, 0) + 1);
        }


        for ( int i = 0 ; i < puzzles.length; i++) {
            int count = 0 ;
            int p = getMask(puzzles[i]);
            for(int j = p; j > 0 ; j = (j-1) & p ){
                if ( ((1 << (puzzles[i].charAt(0) - 'a') ) & j) != 0 ){
                    count += wmap.getOrDefault(j, 0);
                }
            }
            ans.add(count);
        }
        return ans;
    }



    public static void main(String args[]) {
        NumberofValidWordsforEachPuzzle numberofValidWordsforEachPuzzle = new NumberofValidWordsforEachPuzzle();
//        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
//        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

        String[] words = {"apple","pleas","please"};
        String[] puzzles = {"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};

        numberofValidWordsforEachPuzzle.findNumOfValidWords(words, puzzles);
    }
}
