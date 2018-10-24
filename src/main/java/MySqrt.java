public class MySqrt {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        int start = 0;
        int end = x / 2;

        while (start < end) {
            long mid = (long)(start + end) / 2;
            long value = mid * mid;

            if (value == x) {
                return (int)mid;
            } else if (value < x) {
                start = (int)mid + 1;
            } else {
                end = (int)mid;
            }
        }


        return (long)start * start <= x ? start : start - 1;

    }
}
