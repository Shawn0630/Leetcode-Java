package com.strings;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int i = 0;
        int idx = 0;
        while (i < s.length()) {
            if (sc[i] == '#') {
                if (idx > 0) {
                    idx--;
                }
            } else {
                sc[idx++] = sc[i];
            }
            i++;
        }

        int j = 0;
        int jdx = 0;
        while (j < t.length()) {
            if (tc[j] == '#') {
                if (jdx > 0) {
                    jdx--;
                }
            } else {
                tc[jdx++] = tc[j];
            }
            j++;
        }

        if (idx != jdx) {
            return false;
        }

        return isSame(sc, tc, idx);
    }


    private boolean isSame(char[] sc, char[] tc, int size) {
        for(int i = 0; i < size; i++) {
            if (sc[i] != tc[i]) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        backspaceStringCompare.backspaceCompare("y#fo##f", "y#f#o##f");
    }
}
