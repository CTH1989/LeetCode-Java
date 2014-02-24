public class Solution {
    public int minCut(String s) {
        int len = s.length();
        if (len == 0 || len == 1)
            return 0;
        boolean[][] visit = new boolean[len][len];
        int[] dp = new int[len];
        
        for (int nn = 1; nn <= len; nn ++) {
            for (int i = 0; i <= len - nn; i ++) {
                int j = i + nn - 1;
                if (i == j) visit[i][j] = true;
                else if(j == i + 1 && s.charAt(i) == s.charAt(j)) visit[i][j] = true;
                else if (visit[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) visit[i][j] = true;
            }
        }
        
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            int ret = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (visit[j][i]) {
                    if (j == 0) {
                        ret = 0;
                    } else if (dp[j - 1] + 1 < ret) {
                        if (dp[j - 1] + 1 < ret)
                            ret = dp[j - 1] + 1;
                    }
                }
            }
            dp[i] = ret;
        }
        return dp[len - 1];
    }
}
