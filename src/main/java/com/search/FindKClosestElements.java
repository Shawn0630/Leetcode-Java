package com.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindKClosestElements {
    // constraints:
    // 1. arr is not a null
    // 2. k <= arr.length
    // [1,2,3,4,5] k = 4, x = 3
    // index = 3

    // [1,2,3,4,5] k = 4, x = -1
    // index = 0
    // sorted
    // https://leetcode.com/problems/find-k-closest-elements/discuss/202785/Very-simple-Java-O(n)-solution-using-two-pointers
    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        // find the closest element
        int low = 0, high = arr.length - 1;

        // how to confirm low is the closest element
        while (low < high) { // exit condition low == high
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                low = mid;
                break;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        low = low - 1 >= 0 && x - arr[low - 1] <= arr[low] - x ? low - 1 : low;
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[low]);
        k--;
        int left = low - 1, right = low + 1;
        while (k > 0) {
            int leftDiff = left >= 0? x - arr[left] : Integer.MAX_VALUE;
            int rightDiff = right < arr.length ? arr[right] - x : Integer.MAX_VALUE;

            if(leftDiff <= rightDiff) {
                ans.add(arr[left]);
                left--;
            } else {
                ans.add(arr[right]);
                right++;
            }

            k--;
        }

        ans.sort(Comparator.comparingInt(a -> a));

        return ans;
    }

    public static void main(String[] args) {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        findKClosestElements.findClosestElements(new int[]{1,2,3,4,4,4,4,5,5}, 3, 3);
    }
}
