public class Solution {
    public void dfs(int[] num, int np, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path, int k) {
        if (np == num.length) {
            if (k == 0) {
                ArrayList<Integer> ret = (ArrayList<Integer>) path.clone();
                ans.add(ret);
            }
            return ;
        }
        dfs(num, np + 1, ans, path, k);
        path.add(num[np]);
        dfs(num, np + 1, ans, path, k - 1);
        path.remove(path.size() - 1);
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (n == 0 || k == 0)
            return ans;
        int[] num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = i + 1;
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(num, 0, ans, path, k);
        return ans;
    }
}
