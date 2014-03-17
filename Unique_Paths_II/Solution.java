public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (n == 0)
            return 0;
            
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            else
                dp[i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    if (dp[j] == 1 && obstacleGrid[i][j] == 0)
                        dp[j] = 1;
                    else
                        dp[j] = 0;
                } else {
                    if (obstacleGrid[i][j] == 1)
                        dp[j] = 0;
                    else
                        dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
