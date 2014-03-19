public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        if (n == 0)
            return false;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
            return false;
        int l = 0, r = m - 1, mid = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        int row = r;
        l = 0;
        r = n - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}
