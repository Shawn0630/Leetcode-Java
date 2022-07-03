package com.sorting;

import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {
    int mod = 10 ^ 9 + 7;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxLength = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for(int i = 1; i < horizontalCuts.length; i++) {
            maxLength = Math.max(maxLength, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for(int i = 1; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int)((maxLength * maxWidth) % (1000000007));

    }
}
