public class Solution {
    public boolean isNumber(String s) {
        boolean dot = false;
        boolean exp = false;
        boolean num = false;
        char[] str = s.toCharArray();
        int len = str.length, start = -1, end = -1;
        for (int i = 0; i < len; i++) {
            if (str[i] != ' ') {
                start = i;
                break;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                end = i;
                break;
            }
        }
        if (start == -1 || end == -1)
            return false;
        if (start == end && str[start] == '.') return false;
        for (int i = start; i <= end; i++) {
            if ((str[i] >= '0' && str[i] <= '9') || str[i] == 'e'
                    || str[i] == '.' || str[i] == '-' || str[i] == '+') {
                if (str[i] == '.') {
                    if (dot || exp)
                        return false;
                    dot = true;
                } else if (str[i] == 'e') {
                    if (i == start || i == end)
                        return false;
                    if (!num) return false;
                    if (exp) return false;
                    exp = true;
                } else if(str[i] == '-' || str[i] == '+') {
                    if (i == end) return false;
                    if (i == start) continue;
                    if (str[i - 1] != 'e') return false;
                } else num = true;
            } else
                return false;
        }
        if (num) return true;
        else return false;
    }
}
