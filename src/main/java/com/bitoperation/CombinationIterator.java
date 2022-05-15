package com.bitoperation;

public class CombinationIterator {
    int charLength;
    int combinationLength;
    char[] charsArray;
    int curMask;

    public CombinationIterator(String characters, int combinationLength) {
        this.charLength = characters.length();
        this.charsArray = characters.toCharArray();
        this.combinationLength = combinationLength;
        this.curMask = ((1 << combinationLength) - 1) << (charLength - combinationLength);
    }

    public String next() {
        if (!hasNext()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = charLength - 1; i >= 0; i--) {
            if ((curMask & (1 << i)) != 0) {
                sb.append(charsArray[charLength - 1 - i]);
            }
        }

        curMask--;
        return sb.toString();
    }

    public boolean hasNext() {
        while (curMask >= 0 && hammingWeight(curMask) != this.combinationLength) curMask--;
        return curMask >= 0;
    }

    private int hammingWeight(int n) {
        int i = 32;
        int count = 0;
        while (i > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
            i--;
        }

        return count;
    }
}
