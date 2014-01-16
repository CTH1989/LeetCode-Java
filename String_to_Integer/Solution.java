public class Solution {
    public int atoi(String str) {
        if (str == null) return 0;
        char strArr[] = str.toCharArray();
        int ret = 0, len = strArr.length, np = 0, pp = 0;
        int sign = 1;
        if (len == 0) return 0;
        
        while (np < len && strArr[np] == ' ') {
            np ++;
        }
        if (np == len) return ret;
        if (strArr[np] == '-') {
            sign = -1;
            np ++;
        } else if (strArr[np] == '+') {
            np ++;
        }
        
        pp = np;
        while (pp < len && strArr[pp] >= '0' && strArr[pp] <= '9') {
            pp ++;
        }
        
        if (np == pp) return 0;
        pp --;
        
        if (pp - np > 9) {
            if (sign == 1) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        
        for (int i = np; i <= pp; i ++) {
            if (i == pp && pp - np == 9) {
                if (sign == 1) {
                    if (ret > (Integer.MAX_VALUE / 10)) return Integer.MAX_VALUE;
                    else if (ret == (Integer.MAX_VALUE / 10)){
                        if (strArr[i] > '7') return Integer.MAX_VALUE;
                    }
                } else {
                    if (ret > (-1) * (Integer.MIN_VALUE / 10)) return Integer.MIN_VALUE;
                    else if (ret == (-1) * (Integer.MIN_VALUE / 10)){
                        if (strArr[i] > '8') return Integer.MIN_VALUE;
                    }
                }
            }
            ret *= 10;
            ret += (strArr[i] - '0');
        }
        
        return sign * ret;
    }
}
