public class Solution {
    public int numDecodings(String s) {
    	char[] chArr = s.toCharArray();
    	int i, index, len = chArr.length;
    	int dp[] = new int[len + 1];
    	
    	if (len == 0) return 0;
    	
    	if (chArr[0] == '0') return 0;
    	else dp[1] = 1;
    	dp[0] = 1;
    	
    	for (i = 2; i <= len; i ++) {
    		index = i - 1;
    		if (chArr[index] == '0') {
    			if (chArr[index - 1] < '3' && chArr[index - 1] > '0') {
    				dp[i] = dp[i - 2];
    			} else return 0;
    		} else {
    			dp[i] = dp[i - 1];
    			int tmp = 0;
    			tmp = (chArr[index - 1] - '0') * 10 + (chArr[index] - '0');
    			if (tmp < 27 && tmp > 9) dp[i] += dp[i - 2];
    		}
    	}
    	
    	return dp[len];
    }
    // 100 0
    // 101 1
}
