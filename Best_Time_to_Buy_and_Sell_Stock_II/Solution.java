public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int ans = 0;
        int np = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                ans += (prices[i - 1] - prices[np]);
                np = i;
            }
        }
        ans += prices[prices.length - 1] - prices[np];
        return ans;
    }
}
