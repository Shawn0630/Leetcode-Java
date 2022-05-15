package com.strings;

public class StringCompression {

    //      0       1       2       3       4       5       6
    //      "a",    "a",    "b",    "b",    "c",    "c",    "c"
    //
    public int compress(char[] chars) {
        int i = 0;
        int idx = 0;
        while (i < chars.length) {
            int j = i + 1;
            while (j < chars.length && chars[j] == chars[j - 1]) j++;
            chars[idx++]=chars[i];
            if (j - i > 1) {
                String count = String.valueOf(j - i);
                for (char c : count.toCharArray()) {
                    chars[idx++] = c;
                }
            }

            i = j;
        }

        return idx;
    }

    public static void main(String[] args) {
        StringCompression compression = new StringCompression();
        compression.compress(new char[]{'a'});
    }
}
