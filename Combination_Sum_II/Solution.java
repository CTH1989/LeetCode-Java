import java.util.Hashtable;
public class Solution {
    Hashtable<ArrayList<Integer>, Integer> hash;
    public void dfs(int[] num, int sum, int np, int target, ArrayList<Integer> ret, ArrayList<ArrayList<Integer>> ans) {
        if (sum == target) {
            if (!hash.containsKey(ret)) {
                ArrayList<Integer> _ret = (ArrayList<Integer>) ret.clone();
                ans.add(_ret);
                hash.put(_ret, 1);
            }
            return ;
        } else if (sum > target)
            return ;
        int len = num.length;
        if (np >= len)
            return ;
        ret.add(num[np]);
        dfs(num, sum + num[np], np + 1, target, ret, ans);
        ret.remove(ret.size() - 1);
        dfs(num, sum, np + 1, target, ret, ans);
        return ;
    }
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
                ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len == 0)
            return ans;
        Arrays.sort(num);
        hash = new Hashtable<ArrayList<Integer>, Integer>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        dfs(num, 0, 0, target, ret, ans);
        return ans;
    }
}
