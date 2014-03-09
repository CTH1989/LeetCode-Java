public class Solution {
    char[][] board;
    public boolean check(int x, int y, int t) {
        int[] cx = new int[10];
        cx[t] ++;
        for (int i = 0; i < 9; i ++) {
            char ch = board[x][i];
            if (ch >= '1' && ch <= '9') {
                cx[ch - '0'] ++;
                if (cx[ch - '0'] > 1)
                    return false;
            }
        }
        int[] cy = new int[10];
        cy[t]++;
        for (int i = 0; i < 9; i ++) {
            char ch = board[i][y];
            if (ch >= '1' && ch <= '9') {
                cy[ch - '0'] ++;
                if (cy[ch - '0'] > 1)
                    return false;
            }
        }
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1, 0};
        int[] chk = new int[10];
        chk[t] ++;
        int xx = x / 3 * 3 + 1;
        int yy = y / 3 * 3 + 1;
        for (int k = 0; k < 9; k ++) {
            char ch = board[xx + dx[k]][yy + dy[k]];
            if (ch >= '1' && ch <= '9') {
                chk[ch - '0'] ++;
                if (chk[ch - '0'] > 1)
                    return false;
            }
        }
        
        return true;
    }
    public boolean dfs(ArrayList<Integer> xList, ArrayList<Integer> yList, int s, int num) {
        if (num == 0)
            return true;
        int i = xList.get(s);
        int j = yList.get(s);
        for (int k = 1; k<= 9; k ++) {
            if (check(i, j, k)) {
                board[i][j] = (char) (k + 48);
                if (dfs(xList, yList, s + 1, num - 1))
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        this.board = board;
        int num = 0;
        ArrayList<Integer> xList = new ArrayList<Integer>();
        ArrayList<Integer> yList = new ArrayList<Integer>();
        for (int i = 0; i < 9; i ++)
            for (int j = 0; j < 9; j ++)
                if (board[i][j] == '.') {
                    xList.add(i);
                    yList.add(j);
                    num ++;
                }
        dfs(xList, yList, 0, num);
    }
}
