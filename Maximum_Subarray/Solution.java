public class Solution {
    public int maxSubArray(int[] A) {
        int len = A.length;
        if (len < 0)
            return 0;
        int[] dp = new int[len];
        int ans = A[0];
        dp[0] = A[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
            if (dp[i] > ans)
                ans = dp[i];
        }
        return ans;
    }
}
