package com.stack;

import java.util.Stack;

public class BasicCalculatorII {

    // case#1: 1 + 2 + 3
    // case#2: 1 + 2 - 3
    // case#3: 1 + 2 * 3
    // case#4: 1 + 2 / 3
    // case#5: 1  *     2       * 3
   //         prevOp current currentOp
    // when new op shows up, define prev
    public int calculate(String s) {
        int prev = 0;
        int current = 0;
        int sum = 0;
        char prevOp = '+';

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                current = current * 10 + c - '0';
            } else if (c == ' ') continue;
            if (i == s.length() - 1 || (c == '+' || c == '-' || c == '*' || c == '/')){
                if (prevOp == '*') {
                    prev = prev * current;
                } else if (prevOp == '/') {
                    prev = prev / current;
                } else if (prevOp == '+') {
                    sum += prev;
                    prev = current;
                } else if (prevOp == '-') {
                    sum += prev;
                    prev = -current;
                }

                prevOp = c;
                current = 0;
            }
        }


        return sum + prev;
    }

    public int calculate3(String s) {

        int prev = 0;
        int current = 0;
        int sum = 0;
        char op = '+';

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
           if (Character.isDigit(c)) {
                current = current * 10 + c - '0';
           }
           if (i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
               // prev   current
               // 1   op  2 +-*/ 3
               if (op == '+') { // lowest
                   sum += prev;
                   prev = current;
               } else if (op == '-') {
                   sum += prev;
                   prev = -current;
               } else if (op == '*') {
                   prev = prev * current;
               } else if (op == '/') {
                   prev = prev / current;
               }
               op = c;
               current = 0;
           }
        }

        return sum + prev;
    }

    // assumptions/constraints.
    // s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
    // valid experssion
    public int calculate4(String s) {
        int prev = 0;
        int cur = 0;
        char op = '+';
        int sum = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            } else if (i == s.length() - 1 || c == '+' || c == '-' ||
                       c == '*' || c == '/') {
                if (op == '+') { // [sum + ]prev + cur ? => [sum +] prev ?
                    sum += prev;
                    prev = cur;
                } else if (op == '-') { // [sum + ]prev - cur ?
                    sum += prev;
                    prev = -cur;
                } else if (op == '*') { // [sum + ]prev * cur ?
                    prev = prev * cur;
                } else if (op == '/') { // [sum + ]prev / cur ?
                    prev = prev / cur;
                }


                cur = 0;
                op = c;
            }
        }

        return sum + prev;

    }


    public int calculate5(String s) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int cur = 0;
        char op = '+';

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }
            if (i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if (op == '+') {
                    stack.push(cur);
                } else if (op == '-') {
                    stack.push(-cur);
                } else if (op == '*') { // * cur
                    if (!stack.empty()) {
                        int prev = stack.pop();
                        stack.push(prev * cur);
                    }
                } else if (op == '/') {
                    if (!stack.empty()) {
                        int prev = stack.pop();
                        stack.push(prev / cur);
                    }
                }

                op = c;
                cur = 0;
            }
        }

        while (!stack.empty()) {
            sum += stack.pop();
        }

        return sum;
    }
    //      op      c
    // a    *   b    +    c
    // prev     cur
    public int calculate6(String s) {
        int res = 0;
        int op = '+';
        int cur = 0;
        int prev = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (op == '+') {
                    res += prev;
                    prev = cur;
                } else if (op == '-') {
                    res += prev;
                    prev = -cur;
                } else if (op == '*') {
                    prev = prev * cur;
                } else if (op == '/') {
                    prev = prev / cur;
                }

                op = c;
                cur = 0;
            }
        }

        return res + prev;
    }
}
