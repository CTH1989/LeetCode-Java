public class Solution {
    public void dfs(int[] candidates, int sum, int np, int target, ArrayList<Integer> ret, ArrayList<ArrayList<Integer>> ans) {
        if (sum == target) {
            ArrayList<Integer> _ret = (ArrayList<Integer>) ret.clone();
            // Collections.sort(_ret);
            ans.add(_ret);
            return ;
        } else if (sum > target)
            return ;
        int len = candidates.length;
        for (int i = np; i < len; i++) {
            if (candidates[i] <= target) {
                ret.add(candidates[i]);
                dfs(candidates, sum + candidates[i], i, target, ret, ans);
                ret.remove(ret.size() - 1);
            }
        }
        return ;
    }
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int len = candidates.length;
        if (len == 0)
            return ans;
        Arrays.sort(candidates); //
        ArrayList<Integer> ret = new ArrayList<Integer>();
        dfs(candidates, 0, 0, target, ret, ans);
        return ans;
    }
}
