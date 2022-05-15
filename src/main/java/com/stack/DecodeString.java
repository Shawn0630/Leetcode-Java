package com.stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if (s == null){
            return null;
        }

        int remain = 0;
        char[] characters = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int i = 0; i < characters.length; i++) {
            if (Character.isDigit(characters[i])) {
                count = count * 10 + characters[i] - '0';
            } else if (characters[i] == '[') {
                remain++;
                String decodedString = decodeString(s.substring(i + 1));
                i++;
                while (i < characters.length && remain > 0) {
                    if (characters[i] == '[') remain++;
                    else if (characters[i] == ']') remain--;
                    i++;
                }
                while(count > 0) {
                    sb.append(decodedString);
                    count--;
                }
                i--;
            } else if (characters[i] == ']') {
                return sb.toString();
            } else {
                sb.append(characters[i]);
            }
        }

        return sb.toString();
    }


    public String decodeString2(String s) {
        if (s == null) {
            return null;
        }

        Stack<String> stringStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();

        char[] characters = s.toCharArray();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char character : characters) {
            if (Character.isDigit(character)) {
                count = count * 10 + character - '0';
            } else if (character == '[') {
                intStack.push(count);
                count = 0;
                stringStack.push(sb.toString());
                sb = new StringBuilder();
            } else if (character == ']') {
                int times = intStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                while (times > 0) {
                    temp.append(sb.toString());
                    times--;
                }
                sb = temp;
            } else {
                sb.append(character);
            }
        }

       return sb.toString();
    }

    public String decodeString3(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int i = 0;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                String sub = decodeString3(s.substring(i + 1));
                while (num > 0) {
                    sb.append(sub);
                    num--;
                }
            } else if (s.charAt(i) == ']') {
                return sb.toString();
            }
            i++;
        }

        return sb.toString();
    }



    /*
    *   3[a]2[bc]
    *
    *    aaa bcbc
    * */
    public String decodeString4(String s) {
        return decodeString4DFS(s, 0).str;
    }

    private Node decodeString4DFS(String s, int cur) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i;
        for(i = cur; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count = count * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                Node remain = decodeString4DFS(s, i + 1);
                while (count > 0) {
                    sb.append(remain.str);
                    count--;
                }
                i = remain.next;
            } else if (s.charAt(i) == ']') {
                break;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return new Node(sb.toString(), i);
    }

    private class Node {
        String str;
        int next;

        public Node(String str, int next) {
            this.str = str;
            this.next = next;
        }
    }

    // 3[a]2[bc]
    int i = 0;
    public String decodeString5(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c >= '0' && c <= '9') { // digit
                count = (count * 10 + c - '0');
            } else if (c == '[') {
                String str = decodeString(s);
                while (count > 0) {
                    sb.append(str);
                    count--;
                }
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }

        }

        return sb.toString();
    }
}
