package com.stack.monotonic_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null ||
            nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[nums2.length];
        for(int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums2[i]) stack.pop(); // stack.peek() > stack.[peek() - 1]
            nextGreater[i] = stack.empty() ? -1 : stack.peek(); // stack.peek() > nums2[i]
            stack.push(nums2[i]); // nums2[i] > stack.peek()
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nextGreater[i]);
        }
        int[] ans = new int[nums1.length];
        int idx = 0;
        for(int num : nums1) {
            ans[idx++] = map.get(num);
        }

        return ans;
    }
}
