public class Solution {
    public ArrayList<ArrayList<Integer>> powerset(int[] S, int n) {
        if (n == -1) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
            ans.add(ret);
            return ans;
        }
        ArrayList<ArrayList<Integer>> ret = powerset(S, n - 1);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int len = ret.size();
        ans.addAll(ret);
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> np = (ArrayList<Integer>) ret.get(i).clone();
            np.add(S[n]);
            ans.add(np);
        }
        return ans;
    }
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        int len = S.length;
        if (len == 0)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> ans = powerset(S, len - 1);
        return ans;
    }
}
