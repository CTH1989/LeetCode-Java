public class Solution {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder(), ret;
        int len, np, i;
        char nc;
        ans.append("1");
        while (--n != 0) {
            ret = new StringBuilder();
            len = ans.length();
            nc = ans.charAt(0);
            np = 0;
            for (i = 0; i < len; i ++) {
                if (ans.charAt(i) != nc) {
                    ret.append(i - np);
                    ret.append(nc);
                    nc = ans.charAt(i);
                    np = i;
                }
            }
            ret.append(i - np);
            ret.append(nc);
            ans = ret;
        }
        return ans.toString();
    }
}
