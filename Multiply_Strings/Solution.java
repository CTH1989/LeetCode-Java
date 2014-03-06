public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        String ans = "";
        if (len1 * len2 == 0) return ans;
        if (len1 < len2)
            return multiply(num2, num1);
        if (len2 == 1 && num2.charAt(0) == '0')
            return "0";
        
        int[] ret = new int[len1 * len2 + 5];
        
        for (int i = len2 - 1 ; i >= 0; i --) {
            int n2 = num2.charAt(i) - '0';
            for (int j = len1 - 1; j >= 0; j --) {
                int n1 = num1.charAt(j) - '0';
                int np = n1 * n2;
                ret[j + i + 1] += np;
            }
        }
        int tmp = 0;
        for (int i = (len1 - 1) + (len2 - 1); i >= 0; i --) {
            int index = i + 1;
            ret[index] += tmp;
            tmp = ret[index] / 10;
            ret[index] %= 10;
        }
        if (tmp != 0)
            ret[0] = tmp;
        for (int i = 0; i <= (len1 - 1) + (len2 - 1) + 1; i ++) {
            if (i == 0) {
                if (ret[0] != 0)
                    ans += ret[i];
            } else {
                ans += ret[i];
            }
        }
        return ans;
    }
}
