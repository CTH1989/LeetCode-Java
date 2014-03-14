public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] matrix = new int[m + 1][n + 1];
        matrix[0][0] = 0;
        for (int i = 0; i < m; i++)
            matrix[i + 1][0] = i + 1;
        for (int i = 0; i < n; i++)
            matrix[0][i + 1] = i + 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1);
                int d = 0;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    d = 0;
                else
                    d = 1;
                matrix[i][j] = Math.min(tmp, matrix[i - 1][j - 1] + d);
            }
        }
        return matrix[m][n];
    }
}
