package com.array.two_pointers;

public class ValidPalindromeII {
    // abc => false
    // abba => true
    // abcba => true
    // abcaba => true
    // ababaa => true

    // "aguokepatgbnvfqmgml
    // cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu
    // lmgmqfvnbgtapekouga"
    //https://leetcode.com/problems/valid-palindrome-ii/discuss/391809/Java-Solutions-to-Valid-Palindrome-I-and-II-with-Explanation-(SubPalindrome-Iteration-and-Recursion)
    public boolean validPalindrome(String s) {
        char[] carray = s.toCharArray();
        int left = 0, right = carray.length - 1;

        while (left < right) {
            if (carray[left] == carray[right]) {
                left ++;
                right --;
            } else {
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    private boolean validPalindrome(String s, int start, int end) {
        char[] carray = s.toCharArray();
        while(start < end) {
            if (carray[start] != carray[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

}
