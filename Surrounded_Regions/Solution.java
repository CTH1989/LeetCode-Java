public class Solution {
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return ;
        int n = board[0].length;
        if (n == 0) return ;
        Queue<int[]> que = new LinkedList<int[]>();
        for (int i = 0; i < n; i ++) {
            if (board[0][i] == 'O') {
                int[] point = {0, i};
                que.offer(point);
            }
            if (m != 1 && board[m - 1][i] == 'O') {
                int[] point = {m - 1, i};
                que.offer(point);
            }
        }
        for (int i = 1; i < m - 1; i ++) {
            if (board[i][0] == 'O') {
                int[] point = {i, 0};
                que.offer(point);
            }
            if (n != 1 && board[i][n - 1] == 'O') {
                int[] point = {i, n - 1};
                que.offer(point);
            }
        }
        while (!que.isEmpty()) {
            int[] point = que.poll();
            int x = point[0], y = point[1];
            board[x][y] = 'C';
            for (int i = 0; i < 4; i ++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >=0 && xx < m && yy >= 0 && yy < n) {
                    if (board[xx][yy] == 'O') {
                        int[] _point = {xx, yy};
                        que.offer(_point);
                    }
                }
            }
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++ ) {
                if (board[i][j] == 'C')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
