import java.util.Arrays;
import java.util.PriorityQueue;
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

    // PriorityQueue
    // 3, 1, 2, 4   3
    // MinQueue   3    1  3    1  2   3    {1}   2   3   4
    // MaxQueue   3    3  1    3  2   1    {4}   3   2   1
    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> distance(b) - distance(a));

        for(int[] point : points) {
            queue.offer(point);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] ans = new int[k][];
        int idx = 0;

        while (!queue.isEmpty()) {
            ans[idx++] = queue.poll();
        }
        return ans;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }


    public int[][] kClosest3(int[][] points, int k) {
        return topK(points, k);
    }

    private int[][] topK(int[][] points, int k) {
        int left = 0, right = points.length - 1;

        while (left <= right) {
            int index = quickSelect(points, left, right);
            if (index == k - 1) {
                break;
            } else if (index > k - 1){
                right = index - 1;
            } else { // index < k
                left = index + 1;
            }
        }

        return Arrays.copyOf(points, k);
    }


    // small  pivot  large
    private int quickSelect(int[][] points, int left, int right) {
        int pivot = distance(points[left]);
        int pivotIndex = left;

        while (left <= right) {
            while (left <= right && distance(points[left]) <= pivot) left++;
            while (left <= right && distance(points[right]) >= pivot) right--;
            if (left < right) {
                swap(points, left, right);
            }
        }

        swap(points, right, pivotIndex);

        return right;
    }

    // swap between left and right
    private void swap(int[][] points, int left, int right) {
        int[] temp = points[left];
        points[left] = points[right];
        points[right] = temp;
    }


    public static void main(String[] args) {
        KClosestPointstoOrigin kClosestPointstoOrigin = new KClosestPointstoOrigin();
//        kClosestPointstoOrigin.kClosest3(new int[][]{{1, 3}, {-2, 2}}, 1);
        kClosestPointstoOrigin.kClosest3(new int[][]{{3,3}, {5,-1},{-2,4}}, 2);
    }

}
