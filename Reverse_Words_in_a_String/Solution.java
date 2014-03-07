public class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        if (s == null || s.length() == 0)
            return s;
        String[] ss = s.split(" ");
        int len = ss.length;
        for (int i = len - 1; i >= 0 ; i --) {
            if (ss[i].equals(" ") || ss[i].equals(""))
                continue;
            if (i != len - 1)
                ans.append(" ");
            ans.append(ss[i]);
        }
        return ans.toString();
    }
}
