public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            int[] chk = new int[10];
            for (int j = 0; j < 9; j ++) {
                char ch = board[i][j];
                if (ch >= '1' && ch <= '9') {
                    chk[ch - '0'] ++;
                    if (chk[ch - '0'] > 1)
                        return false;
                }
            }
        }
        for (int i = 0; i < 9; i ++) {
            int[] chk = new int[10];
            for (int j = 0; j < 9; j ++) {
                char ch = board[j][i];
                if (ch >= '1' && ch <= '9') {
                    chk[ch - '0'] ++;
                    if (chk[ch - '0'] > 1)
                        return false;
                }
            }
        }
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1, 0};
        for (int i = 1; i < 9; i += 3) {
            for (int j = 1; j < 9; j += 3) {
                int[] chk = new int[10];
                for (int k = 0; k < 9; k ++) {
                    char ch = board[i + dx[k]][j + dy[k]];
                    if (ch >= '1' && ch <= '9') {
                        chk[ch - '0'] ++;
                        if (chk[ch - '0'] > 1)
                            return false;
                    }
                }
            }
        }
        
        return true;
    }
}
