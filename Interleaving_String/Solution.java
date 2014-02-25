public class Solution {
    public void _checkSum(String str, int[] chars, int flag) {
        for (int i = 0; i < str.length(); i ++) {
            char ch = str.charAt(i);
            chars[ch] += flag;
        }
    }
    public boolean checkSum(String s1, String s2, String s3) {
        int chars[] = new int[256];
        _checkSum(s1, chars, 1);
        _checkSum(s2, chars, 1);
        _checkSum(s3, chars, -1);
        for (int i = 0; i < 256; i ++) {
            if (chars[i] != 0)
                return false;
        }
        return true;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        if (len1 == 0)
            return true;
        
        if (!checkSum(s1, s2, s3))
            return false;
            
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i ++)
            dp[i][0] = (s1.substring(0, i).equals(s3.substring(0, i)));
        for (int i = 1; i <= len2; i ++)
            dp[0][i] = (s2.substring(0, i).equals(s3.substring(0, i)));
            
        for (int i = 1; i <= len1; i ++) {
            for (int j = 1; j <= len2; j ++) {
                char ch = s3.charAt(i + j - 1);
                dp[i][j] = ((ch == s1.charAt(i - 1) && dp[i - 1][j]) || ch == s2.charAt(j - 1) && dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }
}
