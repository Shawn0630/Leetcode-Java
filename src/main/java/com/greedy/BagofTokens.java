package com.greedy;

import java.util.Arrays;

public class BagofTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens == null || tokens.length == 0 || P == 0) {
            return 0;
        }

        Arrays.sort(tokens);

        int start = 0;
        int end = tokens.length - 1;
        int score = 0;

        while (start < end) {
            if (P <= tokens[start] && score > 0) {
                P += tokens[end];
                score--;
                end--;
            } else if (P > tokens[start]){
                P -= tokens[start];
                score++;
                start++;
            } else { // score == 0
                return score;
            }
        }

        return P >= tokens[start] ? score + 1 : score;
    }
}
