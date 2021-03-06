public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < min)
                min = prices[i];
            if (prices[i] - min > ans)
                ans = prices[i] - min;
        }
        return ans;
    }
}
