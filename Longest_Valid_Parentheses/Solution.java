public class Solution {
    public int longestValidParentheses(String s) {
        char[] chArr = s.toCharArray();
        int len = s.length(), count, ans;
        boolean[] dp = new boolean[len];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (chArr[i] == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int np = stack.pop();
                    dp[np] = true;
                    dp[i] = true;
                }
            }
        }
        count = 0; ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i ++) {
            if (dp[i]) {
                count ++;
            } else {
                if (count != 0) {
                    ans = Math.max(ans, count);
                    count = 0;
                }
            }
        }
        ans = Math.max(ans, count);

        return ans;
    }
}
