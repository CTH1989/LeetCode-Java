public class Solution {
    public boolean check(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i))
                return false;
        }
        return true;
    }
    public void rec(String str, ArrayList<ArrayList<String>> ans, ArrayList<String> ret) {
        int len = str.length();
        if (len == 0) {
            ArrayList<String> _ret = (ArrayList<String>) ret.clone();
            ans.add(_ret);
        }
        for (int i = 0; i < len; i++) {
            String strNp = str.substring(0, i + 1);
            if (check(strNp)) {
                ret.add(strNp);
                rec(str.substring(i + 1), ans, ret);
                ret.remove(ret.size() - 1);
            }
        }
    }
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        ArrayList<String> ret = new ArrayList<String>();
        rec(s, ans, ret);
        return ans;
    }
}
