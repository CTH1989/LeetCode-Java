public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                dp[i] = grid[0][0];
            else
                dp[i] = dp[i - 1] + grid[0][i];
        }
            
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    dp[j] = dp[j] + grid[i][j];
                else
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
