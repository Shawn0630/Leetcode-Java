package com.search.binary_search;

public class FindinMountainArray {
      interface MountainArray {
        int get(int index);
        int length();
      }

    // array = [1,2,3,4,5,3,1], target = 3
    // 0    1   2   3   4   5   6
    // 1    2   3   4   5   3   1
    // l                        r
    //              m
    // 2

    //  0       1       2
    //  1       5       2
    //  l               r
    //          m
    //
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // mid ~ 0 ... length - 2
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (mountainArr.get(mid) == target) {
                return mid;
            } else {
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) { // mountain point at right, left ... mid increasing
                    if (mountainArr.get(mid) < target && mountainArr.get(right) >= mountainArr.get(mid)) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                } else { // mountain point at left, mid + 1 decreasing
                    if (mountainArr.get(mid) > target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        return mountainArr.get(left) == target ? left : -1;
    }
}
