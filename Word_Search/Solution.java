public class Solution {
    public int dx[] = {-1, 0, 1, 0};
    public int dy[] = {0, -1, 0, 1};
    public boolean[][] visit;
    public char[][] map;
    public boolean dfs(int i, int j, int m, int n, int target, String str) {
        if (str.charAt(0) == map[i][j]) {
            if (target == 1)
                return true;
            visit[i][j] = true;
            for (int k = 0; k < 4; k ++) {
                int xx = i + dx[k];
                int yy = j + dy[k];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && !visit[xx][yy]) {
                    if (dfs(xx, yy, m, n, target - 1, str.substring(1, target)) == true)
                        return true;
                }
            }
            visit[i][j] = false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return false;
        int m = board.length;
        if (m == 0)
            return false;
        int n = board[0].length;
        if (n == 0)
            return false;
        int target = word.length();
        if (target > m * n)
            return false;
        map = board;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if(dfs(i, j, m, n, target, word))
                    return true;
            }
        }
        return false;
    }
}
