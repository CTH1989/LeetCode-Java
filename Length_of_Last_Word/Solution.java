public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String[] ss = s.split(" ");
        int len = ss.length;
        if (len == 0)
            return 0;
        String str = ss[len - 1];
        return str.length();
    }
}
