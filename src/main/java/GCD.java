public class GCD {
    public int generalizedGCD(int num, int[] arr)
    {
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result = gcd(arr[i], result);
        }

        return result;
    }
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
