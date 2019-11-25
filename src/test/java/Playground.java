import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Playground {

    @Test
    public void test1() throws Exception {
        Set<Integer> set = new HashSet<>();
        set.contains(5);
        System.out.print(intToRoman(3900));
        System.out.print(romanToInt("IV"));
    }


    public String intToRoman(int num) throws Exception {
        if (num <=0) {
            throw new Exception("Not support num");
        }

        String[] numerals = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - values[i] >= 0) {
                sb.append(numerals[i]);
                num = num - values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public int romanToInt(String s) throws Exception {
        if (s == null) {
            throw new Exception("null pointer");
        }
        // all upper case
        int[] romToInt = new int[26];
        romToInt['I' - 'A'] = 1;
        romToInt['V' - 'A'] = 5;
        romToInt['X' - 'A'] = 10;
        romToInt['L' - 'A'] = 50;
        romToInt['C' - 'A'] = 100;
        romToInt['D' - 'A'] = 500;
        romToInt['M' - 'A'] = 1000;

        int number = 0;
        // IV - 4
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            char nex;
            if (i + 1 < s.length()) {
                nex = s.charAt(i + 1);
                int curNum = romToInt[cur - 'A'];
                int nexNum = romToInt[nex - 'A'];
                if (nexNum > curNum) {
                    number += (nexNum - curNum);
                    i++;
                } else {
                    number += curNum;
                }
            } else {
                number += romToInt[cur - 'A'];
            }
        }

        return number;
    }

    @Test
    public void testInt() {
        int a = (-1 - 0) / 2;

        System.out.print(a);
    }
}
