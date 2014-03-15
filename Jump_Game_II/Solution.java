public class Solution {
    public int jump(int[] A) {
        int len = A.length;
        if (len == 0)
            return 0;
        int ans = 0;
        int np = 0;
        int pp = 0;
        for (int i = 0; i < len; i++) {
            if (i > pp) {
                pp = np;
                ans++;
            }
            np = Math.max(np, i + A[i]);
        }
        return ans;
    }
}
