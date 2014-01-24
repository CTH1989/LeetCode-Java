public class Solution {
    public int searchInsert(int[] A, int target) {
        int len = A.length, l, r, m;
        l = 0;
        r = len - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (A[m] == target) return m;
            else if (A[m] < target) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}
