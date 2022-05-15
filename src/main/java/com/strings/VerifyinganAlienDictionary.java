package com.strings;

public class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for(int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], orders)) {
                return false;
            }
        }

        return true;
    }

    boolean compare(String a, String b, int[] orders) {
        int ai = 0;
        int bi = 0;

        while (ai < a.length() && bi < b.length()) {
            if (orders[a.charAt(ai) - 'a'] < orders[b.charAt(bi) - 'a']) {
                return true;
            } else if(orders[a.charAt(ai) - 'a'] > orders[b.charAt(bi) - 'a']) {
                return false;
            }
            ai++;
            bi++;
        }

        return a.length() < b.length();
    }


    // A > B > C => true
    // A > B < C => false
    // A > B B > C A < C won't happens
    public boolean isAlienSorted2(String[] words, String order) {
        int[] orders = new int[26];

        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            orders[c - 'a'] = i;
        }

        for(int i = 1; i < words.length; i++) {
            if (!compareTo(words[i - 1], words[i], orders)) return false;
        }


        return true;
    }

    // return true if a <= b,
    // false if a > b
    private boolean compareTo(String a, String b, int[] orders) {
        int ap = 0; // pointer to a
        int bp = 0; // pointer to b

        while (ap < a.length() && bp < b.length()) {
            char ac = a.charAt(ap);
            char bc = b.charAt(bp);
            if (orders[ac - 'a'] < orders[bc - 'a']) {
                return true;
            } else if (orders[ac - 'a'] > orders[bc - 'a']) {
                return false;
            }
            ap++;
            bp++;
        }
        // exit condition ap == a.length || bp == b.length, [0...ap] <= [0...bp]
        // (ap ...a.length) or (bp ... b.length)

        return a.length() <= b.length();
    }
}
