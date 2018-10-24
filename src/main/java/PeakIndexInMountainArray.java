public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int mid = (start + end) / 2;

        while (end - start >= 2) {
            mid = (start + end) / 2;
            if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                start = mid + 1;
            } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                end = mid;
            } else{
                return mid;
            }
        }

        return A[start] > A[end] ? start : end;
    }
}
