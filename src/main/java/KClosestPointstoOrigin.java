import java.util.Arrays;
import java.util.function.BiFunction;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) {
            return null;
        }
        BiFunction<int[], int[], Boolean> comparator = (ints, ints2) -> (ints[0] * ints[0] + ints[1] * ints[1]) <= (ints2[0] * ints2[0] + ints2[1] * ints2[1]);
        quickSort(points, comparator, K);

        return Arrays.copyOfRange(points, 0, K);
    }

    public <T> void quickSort(T[] array, BiFunction<T, T, Boolean> comparator, int l, int r) {
        if (array == null || array.length == 0) {
            return;
        }

        if (l < r) {
            int mid = quickSortHelper(array, l, r, comparator);
            quickSort(array, comparator, l, mid - 1);
            quickSort(array, comparator, mid + 1, r);
        }
    }

    public <T> void quickSort(T[] array, BiFunction<T, T, Boolean> comparator, int k) {
        if (array == null || array.length == 0) {
            return;
        }

        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int mid = quickSortHelper(array, l, r, comparator);
            if (mid == k) {
                return;
            } else if (mid < k){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    private <T> int quickSortHelper(T[] array, int l, int r, BiFunction<T, T, Boolean> comparator) {
        T pivot = array[l];
        while (l < r) {
            while (l < r && comparator.apply(pivot, array[r])) r--;
            array[l] = array[r];
            while (l < r && comparator.apply(array[l], pivot)) l++;
            array[r] = array[l];
        }
        array[l] = pivot;
        return l;
    }
}
