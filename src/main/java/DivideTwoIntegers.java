public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = (dividend ^ divisor) & 0x80000000;
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        if (divisor == 0) return 0;
        long lres = divide(absDividend, absDivisor);
        if (lres > Integer.MAX_VALUE) {
            return (sign == 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return sign == 0 ? (int) lres : -(int) lres;
        }
    }

    public long divide(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long multiple = 1;
        long sum = divisor;
        while ((sum + sum) <= dividend) {
            multiple += multiple;
            sum += sum;
        }

        return multiple + divide(dividend - sum, divisor);
    }
}
