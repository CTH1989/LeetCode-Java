public class Solution {
    public int search(int[] A, int target) {
        int len = A.length, l = 0, r = len - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (A[m] == target)
                return m;
            else if (A[l] < A[m]) {
                if (A[l] <= target && target < A[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (A[l] > A[m]) {
                if (A[m] < target && target <= A[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
