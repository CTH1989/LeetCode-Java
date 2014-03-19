public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int np = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n])
                A[np--] = A[m--];
            else
                A[np--] = B[n--];
        }
        while (m >= 0)
            A[np--] = A[m--];
        while (n >= 0)
            A[np--] = B[n--];
    }
}
