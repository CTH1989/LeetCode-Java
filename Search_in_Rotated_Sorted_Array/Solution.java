public class Solution {
    public int search(int[] A, int target) {
        int len = A.length, l = 0, r = len - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (A[m] == target)
                return m;
            else if (A[m] < target) {
                if (A[l] <= A[r])
                    l = m + 1;
                else {
                    if (A[m] >= A[r])
                        l = m + 1;
                    else {
                        if (A[r] >= target)
                            l = m + 1;
                        else
                            r = m - 1;
                    }
                }
            } else {
                if (A[l] <= A[r])
                    r = m - 1;
                else {
                    if (A[m] <= A[r])
                        r = m - 1;
                    else {
                        if (A[r] >= target)
                            l = m + 1;
                        else
                            r = m - 1;
                    }
                }
            }
        }
        return -1;
    }
}
