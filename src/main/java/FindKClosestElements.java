import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
           return new ArrayList<>();
        }

        int left = 0;
        int right = arr.length - 1;
        int pos = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                if (mid == 0 || arr[mid - 1] < arr[mid]) {
                    pos = mid;
                    break;
                } else {
                    right = right - 1;
                }
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (pos == -1) {
            if (left == 0) {
                pos = 0;
            } else if (Math.abs(arr[left - 1] - x) <= Math.abs(arr[left] - x)) {
                pos = left - 1;
            } else {
                pos = left;
            }
        }

        /*
        *  1    2    3    4   k = 2
        *            pos
        * */
        List<Integer> res = new ArrayList<>();
        int start = pos;
        int end = pos;
        while (end - start + 1 < k) {
            if (start - 1 < 0 || end + 1 >= arr.length) {
                if (start - 1 < 0) {
                    end++;
                } else {
                    start--;
                }
            } else if (Math.abs(arr[start - 1] - x) <= Math.abs(arr[end + 1] - x)) {
                start--;
            } else {
                end++;
            }
        }
        for(int i = start; i <= end; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}
