package com.array.two_pointers;

public class RemoveAllAdjacentDuplicatesinStringII {
    // d    e   e   e   d   b   b   c   c   c   b   d   a   a           k = 3
    //          j   i
    public String removeDuplicates(String s, int k) {
        int[] counter = new int[s.length()];
        char[] sarray = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(sarray[0]);
        counter[0] = 1;
        for(int i = 1; i < s.length(); i++) {
            char c = sarray[i];
            sb.append(c);
            if (sb.length() >= 2 && c == sb.charAt(sb.length() - 2)) {
                counter[sb.length() - 1] = counter[sb.length() - 2] + 1;
                if (counter[sb.length() - 1] == k) {
                    int copyK = k;
                    while (copyK > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                        copyK--;
                    }
                }
            } else {
                counter[sb.length() - 1] = 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesinStringII removeAllAdjacentDuplicatesinStringII = new RemoveAllAdjacentDuplicatesinStringII();
        removeAllAdjacentDuplicatesinStringII.removeDuplicates("deeedbbcccbdaa", 3);
    }
}
