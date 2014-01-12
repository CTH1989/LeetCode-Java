public class Solution {
    // See the details in http://blog.csdn.net/zxzxy1988/article/details/8587244
    public double findKth(int A[], int m, int B[], int n, int k) {
        if (m > n) {
            return findKth(B, n, A, m, k);
        }
        if (m == 0) {
            return 1.0 * B[k - 1];
        }
        if (k == 1) {
            return 1.0 * Math.min(A[0], B[0]);
        }

        int pa = Math.min(k / 2, m);
        int pb = k - pa;

        if (A[pa - 1] < B[pb - 1]) {
            return findKth(Arrays.copyOfRange(A, pa, A.length), m - pa, B, n, k
                    - pa);
        } else if (A[pa - 1] > B[pb - 1]) {
            return findKth(A, m, Arrays.copyOfRange(B, pb, B.length), n - pb, k
                    - pb);
        } else {
            return A[pa - 1];
        }

    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        int num = m + n;
        if (num % 2 == 0) {
            return 1.0 * (findKth(A, m, B, n, (m + n) / 2) + findKth(A, m, B,
                    n, (m + n) / 2 + 1)) / 2.0;
        } else {
            return 1.0 * (findKth(A, m, B, n, (m + n) / 2 + 1));
        }
    }
}
