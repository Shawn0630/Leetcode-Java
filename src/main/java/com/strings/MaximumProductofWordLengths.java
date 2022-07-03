package com.strings;

public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int ans = 0;

        int[] wordPattern = new int[words.length];
        int idx = 0;
        for(String word : words) {
            int num = 0;
            for(char c : word.toCharArray()) {
                num = num | (1 << (c - 'a'));
            }
            wordPattern[idx++] = num;
        }

        for(int i = 0; i < wordPattern.length; i++) {
            for(int j = i + 1; j < wordPattern.length; j++) {
                if ((wordPattern[i] & wordPattern[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }
}
