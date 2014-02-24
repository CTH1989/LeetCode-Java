public class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();
        if (str.length == 0) return true;
        int np = 0;
        char[] ret = new char[str.length];
        for (int i = 0; i < str.length; i ++) {
            if (str[i] >= 'A' && str[i] <= 'Z')
                str[i] += 32;
            if (str[i] >= 'a' && str[i] <= 'z' || str[i] >= '0' && str[i] <= '9') {
                ret[np ++] = str[i];
            }
        }
        int len = np / 2;
        for (int i = 0; i < len ; i ++) {
            if (ret[i] != ret[np - 1 - i])
                return false;
        }
        return true;
    }
}
