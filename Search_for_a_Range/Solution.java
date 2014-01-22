public class Solution {
    public int[] searchRange(int[] A, int target) {
        int len = A.length, l, r, m, ans[] = new int[2];
        l = 0; r = len - 1;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] >= target)
                r = m;
            else l = m + 1;
        }
        ans[0] = r;
        l = 0; r = len - 1;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] <= target)
                l = m + 1;
            else r = m;
        }
        ans[1] = l;
        if (A[ans[0]] != target) {
            ans[0] = -1;
            ans[1] = -1;
        } else {
            if (A[ans[1]] != target)
                ans[1] --;
        }
        return ans;
    }
}
