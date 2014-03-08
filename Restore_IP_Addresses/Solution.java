public class Solution {
    public void dfs(String str, ArrayList<Integer> ret, ArrayList<String> ans) {
        if (ret.size() == 4) {
            if (str.length() == 0) {
                String tmp = "";
                for (int i = 0; i < ret.size(); i ++) {
                    tmp += ret.get(i);
                    if (i != ret.size() - 1)
                        tmp += ".";
                }
                ans.add(tmp);
            } else {
                return ;
            }
        }
        if (str.length() == 0)
            return ;
        int tmp = 0;
        for (int i = 0; i < str.length(); i ++) {
            tmp *= 10;
            tmp += (str.charAt(i) - '0');
            if (tmp >= 0 && tmp <= 255) {
                ret.add(tmp);
                dfs(str.substring(i + 1), ret, ans);
                ret.remove(ret.size() - 1);
            } else
                return ;
            if (tmp == 0)
                break;
        }
    }
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        if (s == null || s.equals(""))
            return ans;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        dfs(s, ret, ans);
        return ans;
    }
}
