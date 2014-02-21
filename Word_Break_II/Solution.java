public class Solution {
    public void getPath(String s, int index,
            ArrayList<ArrayList<Integer>> dp, ArrayList<String> ret,
            ArrayList<String> ans) {
        if (index == -1) {
            String strRet = "";
            for (int i = ret.size() - 1; i >= 0; i--) {
                if (i == 0)
                    strRet += ret.get(i);
                else
                    strRet += ret.get(i) + " ";
            }
            ans.add(strRet);
            return;
        }
        ArrayList<Integer> dpn = dp.get(index);
        for (int i = 0; i < dpn.size(); i++) {
            String strNp = s.substring(dpn.get(i), index + 1);
            ret.add(strNp);
            getPath(s, dpn.get(i) - 1, dp, ret, ans);
            ret.remove(ret.size() - 1);
        }
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        ArrayList<String> ans = new ArrayList<String>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> dpn = new ArrayList<Integer>();
            dp.add(dpn);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    String str = s.substring(0, i + 1);
                    if (dict.contains(str)) {
                        dp.get(i).add(0);
                    }
                }
                if (dp.get(j).size() != 0) {
                    String str = s.substring(j + 1, i + 1);
                    if (dict.contains(str)) {
                        dp.get(i).add(j + 1);
                    }
                }
            }
        }
        if (dp.get(len - 1).size() != 0) {
            ArrayList<String> ret = new ArrayList<String>();
            getPath(s, len - 1, dp, ret, ans);
        }
        return ans;
    }
}
