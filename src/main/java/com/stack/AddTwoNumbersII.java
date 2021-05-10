package com.stack;

import com.linked_list.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> result = new Stack<>();

        ListNode cur = l1;
        while (cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            stack2.push(cur.val);
            cur = cur.next;
        }

//        int sign = 0;
//        while(!stack1.empty() && !stack2.empty()) {
//            int a = stack1.pop();
//            int b = stack2.pop();
//
//            int r = (a + b + sign) % 10;
//            sign = (a + b + sign) / 10;
//
//            result.push(r);
//        }
//
//        while (!stack1.empty()) {
//            int r = (stack1.peek() + sign) % 10;
//            sign = (stack1.pop() + sign) / 10;
//
//            result.push(r);
//        }
//        while (!stack2.empty()) {
//            int r = (stack2.peek() + sign) % 10;
//            sign = (stack2.pop() + sign) / 10;
//
//            result.push(r);
//        }
//        if (sign == 1) {
//            result.push(1);
//        }
//
//        ListNode dummy = new ListNode(-1);
//        cur = dummy;
//        while(!result.empty()) {
//            cur.next = new ListNode(result.pop());
//            cur = cur.next;
//        }
//        return dummy.next;

        ListNode node = new ListNode(0);
        int sum = 0;
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) {
                sum += stack1.pop();
            }
            if (!stack2.empty()) {
                sum += stack2.pop();
            }
            node.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            sum = sum / 10;
            head.next = node;
            node = head;
        }

        return node.val == 0? node.next : node;
    }
}
