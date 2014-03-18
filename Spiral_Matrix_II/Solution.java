public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n == 0)
            return ans;
        int dy[] = {1, 0, -1, 0};
        int dx[] = {0, 1, 0, -1};
        int x = 0, y = 0;
        int count = 1;
        int start = 0;
        int len = n;
        while (count != n * n + 1) {
            if (count == n * n) {
                ans[x][y] = count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < len; j++) {
                    ans[x][y] = count;
                    if (i == 3 && j == len - 2) {
                        count++;
                        break;
                    }
                    if (j != len - 1) {
                        x += dx[i];
                        y += dy[i];
                        count++;
                    }
                }
            }
            len -= 2;
            start++;
            x = start;
            y = start;
        }
        return ans;
    }
}
