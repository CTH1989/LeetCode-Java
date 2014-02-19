public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    String strNp = s.substring(j, i + 1);
                    if (dict.contains(strNp))
                        dp[i] = true;
                }
                if (dp[j]) {
                    String strNp = s.substring(j + 1, i + 1);
                    if (dict.contains(strNp))
                        dp[i] = true;
                }
            }
        }
        return dp[len - 1];
    }
}
