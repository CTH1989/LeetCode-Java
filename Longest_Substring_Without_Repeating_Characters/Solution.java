public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char arr[] = s.toCharArray();
        int len = s.length();
        int dp[] = new int[len + 5];
        int last[] = new int[260];

        for (int i = 0; i < 260; i++) {
            last[i] = 0;
        }

        dp[0] = 0;

        for (int i = 1; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], last[arr[i - 1]]);
            last[arr[i - 1]] = i;
        }

        int ret = 0;
        for (int i = 1; i <= len; i++) {
            ret = ret > (i - dp[i]) ? ret : (i - dp[i]);
        }

        return ret;
    }
}
