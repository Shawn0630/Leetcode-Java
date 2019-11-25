import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][1] > end) {
                end = intervals[i][1];
            }
        }

        list.add(new int[]{start, end});

        int[][] ans = new int[list.size()][];
        int count = 0;
        for(int[] interval : list) {
            ans[count++] = interval;
        }

        return ans;
    }
}
