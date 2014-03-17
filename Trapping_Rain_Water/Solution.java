public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if (A.length < 2)
            return 0;
        int np = 0;
        int ans = 0;
        int[] maxL = new int[len];
        int[] maxR = new int[len];
        int max = A[0];
        for (int i = 1; i < len; i++) {
            maxL[i] = max;
            max = Math.max(max, A[i]);
        }
        max = A[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxR[i] = max;
            int ret = Math.min(maxL[i], maxR[i]) - A[i];
            if (ret > 0)
                ans += ret;
            max = Math.max(max, A[i]);
        }
        return ans;
    }
}
