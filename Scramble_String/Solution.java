public class Solution {
    public void count(String str, int[] num) {
        int len = str.length();
        for (int i = 0; i < len; i ++)
            num[str.charAt(i) - 'a']++;
    }
    public boolean comp(int[] n1, int[] n2) {
        for (int i = 0; i < 30; i ++)
            if (n1[i] != n2[i])
                return false;
        return true;
    }
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2)
            return false;
        if (len1 == 1 && s1.charAt(0) == s2.charAt(0))
            return true;
        int len = len1;
        int[] n1 = new int[30], n2 = new int[30];
        count(s1, n1);
        count(s2, n2);
        if (!comp(n1, n2))
            return false;
        for (int i = 1; i < len; i++) {
             if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }
}
