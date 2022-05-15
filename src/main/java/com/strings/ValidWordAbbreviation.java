package com.strings;

public class ValidWordAbbreviation {
    // substitution, s10n
    // 1. string is null empty
    // 2. word consist of lower case
    // 3. abbr consists of lower case + digit
    // 4. integer in abb fit in 32-bit integer
    // 5. no leading 0

    // intuition
    // two pointer

    // s    u   b   s   t   i   t   u   t   i   o   n
    // i
    //      i
    //        10  9   8   7    6   5   4   3   2   1 i
    //
    // s    10     n
    // j
    //      j   => j   number = 0;
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0; // word index
        int j = 0; // abbr index


        int number = 0;
        while (i < word.length() && j < abbr.length()) {
            char wc = word.charAt(i);
            char ac = abbr.charAt(j);
           if (Character.isDigit(ac)) {
                number = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    int nc = abbr.charAt(j) - '0';
                    if (number == 0 && nc == 0) return false; // leading 0 is invalid
                    number = number * 10 + nc;
                    j++;
                } // exit condition: j == abb.length || abb.charAt(j) not digit
            } else if (number > 0) {
                while (number > 0 && i < word.length()) {
                    i++;
                    number--;
                }// exit condition: number == 0 || i == word.length
            }  else if (wc == ac) {
                i++;
                j++;
            } else {
                return false;
            }
        } // exit condition: i == word.length || j == abb.length

        while (number > 0 && i < word.length()) {
            i++;
            number--;
        }
        return i == word.length() && j == abbr.length() && number == 0;
    }

    //  substitution  sub4u4
    // constraints/assumptions
    // 1. word, abbr not empty, not null
    // 2. word consists of lower case letter only, abbr consist digit + lower case
    public boolean validWordAbbreviation2(String word, String abbr) {
        int wp = 0; // pointer to word
        int ap = 0; // pointer to abbr

        int cur = 0;
        while (wp < word.length() && ap < abbr.length()) {
            char wc = word.charAt(wp);
            char ac = abbr.charAt(ap);

            if (wc == ac) {
                wp++;
                ap++;
            } else if (Character.isDigit(ac)) {
                cur = 0;
                while (ap < abbr.length() && Character.isDigit(abbr.charAt(ap))) {
                    if (cur == 0 && abbr.charAt(ap) == '0') return false;
                    cur = cur * 10 + abbr.charAt(ap) - '0';
                    ap++;
                }
                while (cur > 0 && wp < word.length()) {
                    cur--;
                    wp++;
                }
            } else {
                return false;
            }
        }

        return cur == 0 && wp == word.length() && ap == abbr.length();
    }

    // s    u   b   s   t   i   t   u   t   i   o   n
    // wp
    //      wp
    //          wp
    //              wp(4)
    //                  wp(3)
    //                      wp(2)
    //                          wp(1)
    //                              wp(0)
    //                                    wp(4)
    //                                        3
    //                                           2
    //                                                1    0
    //
    // s    u   b   4   u   4
    // ap
    //      ap
    //          ap
    //              ap =>ap
    //                      ap

    public static void main(String[] args) {
        ValidWordAbbreviation validWordAbbreviation = new ValidWordAbbreviation();
        validWordAbbreviation.validWordAbbreviation("leetcode", "l1e5");
    }

    // a    p   p   l   e
    // i
    //      i
    // a    2   e
    // j
    //      j => j  number = 2

    // "leetcode"
    //"l1e5"

    //              5   4   3   2   1
    // l    e   e   t   c   o   d   e
    // i
    //      i
    //          i
    //              i
    // l    1   e   5
    // j
    //      i => i number =1
    //              j => number = 5
}
