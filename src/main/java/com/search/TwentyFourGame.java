package com.search;

public class TwentyFourGame {
    //https://leetcode.com/problems/24-game/discuss/590062/Java-Clean-code-with-Backtracking
    public boolean judgePoint24(int[] cards) {
        if (cards == null || cards.length != 4) {
            return false;
        }

        double[] double_cards = new double[cards.length];
        for(int i = 0; i < cards.length; i++) {
            double_cards[i] = (double) cards[i];
        }
        return backtrace(double_cards);

    }

    private boolean backtrace(double[] cards) {
        if (cards.length == 1) {
            return Math.abs(cards[0] -  24) < 0.001;
        }

        for(int i = 0; i < cards.length - 1; i++) {
            for(int j = i + 1; j < cards.length; j++) {
                double[] newCards = new double[cards.length - 1];
                int idx = 0;
                for(int k = 0; k < cards.length; k++) {
                    if (k == i || k == j) continue;
                    newCards[idx++] = cards[k];
                }

                for(double result : calculate(cards[i], cards[j])) {
                    newCards[idx] = result;
                    if (backtrace(newCards)) return true;
                }

            }
        }


        return false;
    }

    private double[] calculate(double a, double b) {
        return new double[] {a + b, a - b, b - a, a * b, a / b, b / a};
    }
}
