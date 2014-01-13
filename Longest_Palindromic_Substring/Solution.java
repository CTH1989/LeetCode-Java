public class Solution {
    public String longestPalindrome(String s) {
        // http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
        // insert sentinel into string
        // ^ and $ signs are sentinels appended to avoid bounds checking
        char sArr[] = s.toCharArray();
        char tArr[] = new char[sArr.length * 2 + 5];
        tArr[0] = '^';
        int len = 1;
        for (int i = 0; i < sArr.length; i ++) {
            tArr[len ++] = '#';
            tArr[len ++] = sArr[i];
        }
        tArr[len ++] = '#';
        tArr[len ++] = '$';
        
        // Manacher's Algorithm
        int P[] = new int[len];
        int C = 0, R = 0;
        for (int i = 1; i < len - 1; i ++) {
            int i_mirror = 2 * C - i;
            P[i] = (R > i) ? Math.min(R - i, P[i_mirror]) : 0;
            
            while (tArr[i + P[i] + 1] == tArr[i - P[i] - 1]) {
                P[i] ++;
            }
            
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        
        // Find the maximum
        int max = 0;
        int centerIndex = 0;
        for (int i = 1; i < len - 1; i ++) {
            if (P[i] > max) {
                max = P[i];
                centerIndex = i;
            }
        }
        return s.substring((centerIndex - 1 - max) / 2, (centerIndex - 1 - max) / 2 + max);
    }
}
