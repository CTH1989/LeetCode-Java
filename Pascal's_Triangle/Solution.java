public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0)
            return ans;
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                ArrayList<Integer> ret = new ArrayList<Integer>();
                ret.add(1);
                ans.add(ret);
            } else {
                ArrayList<Integer> ret = new ArrayList<Integer>();
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i)
                        ret.add(1);
                    else {
                        int tmp = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                        ret.add(tmp);
                    }
                }
                ans.add(ret);
            }
        }
        return ans;
    }
}
