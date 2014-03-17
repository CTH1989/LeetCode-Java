public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0)
            return new int[0];
        int[] _ans = new int[len + 1];
        int np = 1;
        for (int i = len - 1; i >= 0; i--) {
            int ret = digits[i] + np;
            _ans[len - i -1] = ret % 10;
            np = ret / 10;
        }
        if (np != 0) {
            _ans[len] = 1;
            len ++;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i ++) {
            ans[i] = _ans[len - 1 - i];
        }
        return ans;
    }
}
