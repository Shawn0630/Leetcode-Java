public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        if (num == 1) return true;

        long start = 0;
        long end = num / 2;

        while (start < end) {
            long mid = (start + end) / 2;
            long value = mid * mid;
            if (value == num) {
                return true;
            } else if (value < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start * start == num;
    }
}
