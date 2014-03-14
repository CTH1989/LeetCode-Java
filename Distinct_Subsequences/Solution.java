public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();
        if (m < n)
            return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                dp[j][i] = dp[j - 1][i] + (S.charAt(j - 1) == T.charAt(i - 1) ? dp[j - 1][i - 1]: 0);
            }
        return dp[m][n];
    }
}
