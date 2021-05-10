package com.strings;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null) {
            return null;
        }

        /**
         *
         *首先统计出每个字符出现的次数，用visited数组永不一个字母是否被访问过，如果访问过则说明该字母在结果字符串中的位置已安排并继续循环，如果没有访问过，我们和结果中最后一个字母比较，如果该字母的ASCII码小并结果中的最后一个字母在统计数组中的值不为0（说明后面还会出现这个字母），那么我们此时就要在结果中删去最后一个字母且将其标记为未访问，然后加上当前遍历到的字母，并且 将其标记为已访问，以此类推直遍历完整个字符串。以“bcabc”为例：
         * 对于第一个字符b，因为b第一次出现，则保留下来，res="b";
         * 对于第二个字符c，因为c第一次出现，而且比b大，则保留下来，res="bc"；
         * 对于第三个字符a，因为a第一次出现，所以应该保留，但a比b和c都小，则分为两种情况：
         * 如果在原字符串中，a后面还有b则应该把b移除，则把a放在c的后面,res="ca"；有c时同理，res="a";
         * 如果在原字符串中，a后面没有b和c，则只能把a放在bc后面，res="bca"
         *
         */
        int[] count = new int[26];
        boolean[] visited  = new boolean[26];//标记数组，标记每个字符是否被访问过。默认初始化为false

        for(int i = 0; i < s.length(); i++) count[s.charAt(i)-'a']++;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;

            if(visited[s.charAt(i)-'a']) continue;

            while (!stack.empty() && stack.peek() > s.charAt(i) && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            stack.push(s.charAt(i));
            visited[s.charAt(i)-'a'] = true;
        }

        StringBuilder res = new StringBuilder();
        for(char ch : stack)
            res.append(ch);

        return res.toString();
    }
}
