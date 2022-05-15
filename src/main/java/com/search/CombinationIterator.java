package com.search;

class CombinationIterator {

    // https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-%28Subsets-Permutations-Combination-Sum-Palindrome-Partioning%29
    // https://leetcode.com/problems/iterator-for-combination/discuss/1576856/All-5-Solutions-w-Detailed-Explanations-or-Bitmask-%2B-Backtrack-%2B-On-The-Fly-%2B-Gosper's-Hack
    char[] nextChar;
    String characters;
    String cur;
    int combinationLength;
    public CombinationIterator(String characters, int combinationLength) {
        nextChar = new char[26];
        this.characters = characters;
        this.combinationLength = combinationLength;
        char[] chars = characters.toCharArray();
        for(int i = 0; i < characters.length() - 1; i++) {
            nextChar[chars[i] - 'a'] = chars[i + 1];
        }
        nextChar[chars[chars.length - 1] - 'a'] = '$';
        cur = null;
    }

    public String next() {
        if (cur == null) {
            StringBuilder sb = new StringBuilder();
            char currentChar = characters.charAt(0);
            sb.append(currentChar);
            for(int i = 1; i < combinationLength; i++) {
                currentChar = nextChar[currentChar - 'a'];
                sb.append(currentChar);
            }
            cur = sb.toString();
            return cur;
        } else {
            // abcd
            // abc => abd => acd
            char[] chars = cur.toCharArray();
            int i = chars.length - 1;
            while ((i == chars.length - 1 && nextChar[chars[i] - 'a'] == '$') ||
                    (i != chars.length - 1 && i >= 0 && nextChar[chars[i] - 'a'] == chars[i + 1])) i--;
            if (i >= 0) {
                chars[i] = nextChar[chars[i] - 'a'];
            }
            i++;
            while(i > 0 && i < combinationLength && nextChar[chars[i - 1] - 'a'] != '$') {
                chars[i] = nextChar[chars[i - 1] - 'a'];
                i++;
            }
            cur = String.valueOf(chars);
            return cur;
        }
    }

    public boolean hasNext() {
        if (cur == null) {
            return true;
        } else {
            char[] chars = cur.toCharArray();
            int i = chars.length - 1;
            if (nextChar[chars[i] - 'a'] != '$') return true;
            i--;
            while (i >= 0 && nextChar[chars[i] - 'a'] == chars[i + 1]) i--;
            return i >= 0;
        }
    }

    public static void main(String[] args) {
        CombinationIterator ci = new CombinationIterator("abc", 2);

        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());

    }

    /**
     * Permutation, Combination
     *  * next
     *  * sequence
     *
     * */
}
