package com.segement_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        SegmentTree segmentTree = new SegmentTree(min, max);

        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            res.add(segmentTree.query(min, nums[i] - 1));
            segmentTree.update(nums[i]);
        }

        Collections.reverse(res);
        return res;
    }

    private class SegmentTree {
        int[] segment;
        int min;
        int max;
        int len;

        public SegmentTree(int min, int max) {
            this.min = min;
            this.max = max;

            this.len = max - min + 1;
            this.segment = new int[2 * len];

            Arrays.fill(segment, 0);
        }

        public void update(int value) {
            int p = value + this.len - this.min;
            segment[p]++;

            while (p > 0) {
                int l = p;
                int r = p;

                if (l % 2 == 1) {
                    l--;
                }
                if (r % 2 == 0) {
                    r++;
                }

                segment[p / 2] = segment[l] + segment[r];
                p = p / 2;
            }
        }

        public int query(int min, int max) {
            int l = min + this.len - this.min;
            int r = max + this.len - this.min;

            int count = 0;
            while (l <= r) {
                if ((l % 2) == 1) {
                    count += segment[l];
                    l++;
                }
                if ((r % 2) == 0) {
                    count += segment[r];
                    r--;
                }

                l = l / 2;
                r = r / 2;
            }

            return count;
        }
    }


}
