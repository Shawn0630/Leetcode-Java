package com.bitoperation;

import com.linked_list.ListNode;

public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        int ans = 0;

        while (head != null) {
            ans = ans << 1;
            ans |= head.val;

            head = head.next;
        }

        return ans;
    }


    public int getDecimalValue2(ListNode head) {
        int ans = 0;

        ListNode cur = head;
        while(cur != null) {
            ans = ans << 1;
            ans = ans | cur.val;
            cur = cur.next;
        }

        return ans;
    }
}
