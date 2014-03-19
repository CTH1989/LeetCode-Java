public class Solution {
    public int ans;
    public boolean check(int[] queenAt, int r, int c) {
        for(int i = 0; i < r; i++) {
            if (queenAt[i] == c)
                return false;
            if (Math.abs(r - i) == Math.abs(c - queenAt[i]))
                return false;
        }
        return true;
    }
    public void dfs(int[] queenAt, int row, int n) {
        if (row == n) {
            ans ++;
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (check(queenAt, row, i)) {
                queenAt[row] = i;
                dfs(queenAt, row + 1, n);
            }
        }
    }
    public int totalNQueens(int n) {
        ans = 0;
        if (n == 0)
            return ans;
        int[] queenAt = new int[n];
        dfs(queenAt, 0, n);
        return ans;
    }
}
