public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        int len = S.length;
        if (len == 0)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ans.add(new ArrayList<Integer>());
        for (int i = 0; i < len; i++) {
            int num = ans.size();
            for (int j = 0; j < num; j++) {
                ArrayList<Integer> np = (ArrayList<Integer>) ans.get(j).clone();
                np.add(S[i]);
                ans.add(np);
            }
        }
        return ans;
    }
}
