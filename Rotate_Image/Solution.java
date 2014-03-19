public class Solution {
    public int move(int[][] matrix, int val, int i, int j) {
        int tmp = matrix[i][j];
        matrix[i][j] = val;
        return tmp;
    }
    public void rotate(int[][] matrix) {
        // http://oj.leetcode.com/discuss/3064/in-place-solution
        int m = matrix.length;
        if (m == 0)
            return ;
        int n = matrix[0].length;
        if (n == 0)
            return ;
        for (int i = 0; i < m / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                tmp = move(matrix, tmp, j, n - 1 - i);
                tmp = move(matrix, tmp, n - 1 - i, n - 1 - j);
                tmp = move(matrix, tmp, n - 1 - j, i);
                tmp = move(matrix, tmp, i, j);
            }
        }
    }
}
