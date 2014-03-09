public class Solution {
    public void go(int[][] matrix, int x, int y, int m, int n, ArrayList<Integer> ans, int target) {
        if (ans.size() == target)
            return;
        if (m < 0 || n < 0)
            return;
        for (int i = 0; i < n; i++)
            ans.add(matrix[x][y + i]);
        for (int i = 1; i <= m - 2; i++)
            ans.add(matrix[x + i][y + n - 1]);
        if (m > 1) {
            for (int i = n - 1; i >= 0; i--)
                ans.add(matrix[x + m - 1][y + i]);
        }
        if (n > 1) {
            for (int i = m - 2; i >= 1; i--)
                ans.add(matrix[x + i][y]);
        }
        go(matrix, x + 1, y + 1, m - 2, n - 2, ans, target);
    }
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0)
            return ans;
        int n = matrix[0].length;
        if (n == 0)
            return ans;
        go(matrix, 0, 0, m, n, ans, m * n);
        return ans;
    }
}
