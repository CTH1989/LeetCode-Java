public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        if (n == 0)
            return 0;
        
        int[][] H = new int[m][n];
        int[][] L = new int[m][n];
        int[][] R = new int[m][n];
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            int left = 0, right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        H[i][j] = 1;
                        L[i][j] = left;
                    } else {
                        H[i][j] = H[i - 1][j] + 1;
                        L[i][j] = Math.max(L[i - 1][j], left);
                    }
                } else {
                    H[i][j] = 0;
                    L[i][j] = 0;
                    R[i][j] = n;
                    left = j + 1;
                }
            }
            for (int j = n - 1;j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        R[i][j] = right;
                    } else {
                        R[i][j] = Math.min(R[i - 1][j], right);
                    }
                    ans = Math.max(ans, H[i][j] * (R[i][j] - L[i][j]));
                } else {
                    right = j;
                }
            }
        }
        return ans;
    }
}
