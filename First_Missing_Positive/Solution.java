public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        if (n == 0)
            return 1;
        int i = 0;
        while (i < n) {
            if (A[i] != (i + 1) && A[i] >= 1 && A[i] <= n && A[i] != A[A[i] - 1]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else
                i++;
        }
        for (i = 0; i < n; i++) {
            if (A[i] != (i + 1))
                return i + 1;
        }
        return n + 1;
    }
}
