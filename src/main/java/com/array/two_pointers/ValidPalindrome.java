package com.array.two_pointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] sarray = s.toCharArray();

        int left = 0, right = sarray.length - 1;

        while (left < right) {
            if(sarray[left] >= 'A' && sarray[left] <= 'Z') {
                sarray[left] += 'a' - 'A';
            }
            if(sarray[right] >= 'A' && sarray[right] <= 'Z') {
                sarray[right] += 'a' - 'A';
            }
            if (!((sarray[left] >= 'a' && sarray[left] <= 'z') || (sarray[left] >= '0' && sarray[left] <= '9'))) {
                left++;
                continue;
            }
            if (!((sarray[right] >= 'a' && sarray[right] <= 'z') || (sarray[right] >= '0' && sarray[right] <= '9'))) {
                right--;
                continue;
            }

            if (sarray[left] != sarray[right]) {
                 return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
