public class Solution {
    public boolean check(int[] queenAt, int r, int c) {
        for (int i = 0; i < r; i ++) {
            if (queenAt[i] == c)
                return false;
            if (Math.abs(r - i) == Math.abs(c - queenAt[i]))
                return false;
        }
        return true;
    }
    public void dfs(ArrayList<String[]> ans, int[] queenAt, int nRow, int n) {
        if (nRow == n) {
            StringBuilder[] strs = new StringBuilder[n];
            for (int i = 0; i < n; i++) {
                strs[i] = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    strs[i].append('.');
                }
            }
            for (int i = 0; i < n; i++) {
                strs[i].setCharAt(queenAt[i], 'Q');
            }
            String[] ret = new String[n];
            for (int i = 0; i < n; i++)
                ret[i] = strs[i].toString();
            ans.add(ret);
        }
        for (int i = 0; i < n; i ++) {
            if (check(queenAt, nRow, i)) {
                queenAt[nRow] = i;
                dfs(ans, queenAt, nRow + 1, n);
            }
        }
    }
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ans = new ArrayList<String[]>();
        if (n == 0)
            return ans;
        int[] queenAt = new int[n];
        dfs(ans, queenAt, 0, n);
        return ans;
    }
}
