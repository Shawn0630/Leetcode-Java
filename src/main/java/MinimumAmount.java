import java.util.List;

public class MinimumAmount {

    public static long calculateAmount(List<Integer> prices) {
        // Write your code here
        if (prices == null || prices.size() == 0) {
            return 0;
        }

        long ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.size(); i++) {
            if (i == 0) {
                ans += prices.get(i);
                min = prices.get(i);
            } else {
                ans += prices.get(i) - min < 0 ? 0 : prices.get(i) - min;
                if (min > prices.get(i)) {
                    min = prices.get(i);
                }
            }
        }

        return ans;
    }
}
