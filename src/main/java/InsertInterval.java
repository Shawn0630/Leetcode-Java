import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }



        int start = pos(intervals, newInterval);
        int end = secPos(intervals, newInterval);
        int[][] first = Arrays.copyOfRange(intervals, 0, start);
        int[][] third = Arrays.copyOfRange(intervals, end <= intervals.length - 1 && newInterval[1] >= intervals[end][0]? end + 1 : end, intervals.length);
        int a = start >= intervals.length || newInterval[0] < intervals[start][0] ? newInterval[0] : intervals[start][0];
        int b = end < intervals.length && newInterval[1] >= intervals[end][0] ? intervals[end][1] : newInterval[1];
        return joinArrayGeneric(first, new int[][]{{a, b}}, third);
    }

    static <T> T[] joinArrayGeneric(T[]... arrays) {
        int length = 0;
        for (T[] array : arrays) {
            length += array.length;
        }

        //T[] result = new T[length];
        final T[] result = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);

        int offset = 0;
        for (T[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }

    public int pos(int[][] intervals, int[] newInterval) {
        int left = 0;
        int right = intervals.length - 1;
        if (intervals.length == 0) {
            return 0;
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] <= newInterval[0] && newInterval[0] <= intervals[mid][1]) {
                return mid;
            } else if (intervals[mid][0] > newInterval[0]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return newInterval[0] <= intervals[right][1] ? right : right + 1;
    }

    public int secPos(int[][] intervals, int[] newInterval) {
        int left = 0;
        int right = intervals.length - 1;
        if (intervals.length == 0) {
            return 0;
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] <= newInterval[1] && newInterval[1] <= intervals[mid][1]) {
                return mid;
            } else if (intervals[mid][0] > newInterval[1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return newInterval[1] <= intervals[right][1] ? right : right + 1;
    }
}
