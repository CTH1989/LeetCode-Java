public class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        if (len1 == 0 && len2 == 0)
            return "0";
        if (len1 == 0)
            return b;
        if (len2 == 0)
            return a;
        if (len2 > len1)
            return addBinary(b, a);
            
        char[] arr1 = a.toCharArray(), arr2 = b.toCharArray();
        int[] ans = new int[len1 + len2 + 5];
        int np = 0, n1 = len1 -1, n2 = len2 - 1, tmp = 0;
        while (n2 > -1) {
            int cur = (arr1[n1] - '0') + (arr2[n2] - '0') + tmp;
            ans[np++] = cur % 2;
            tmp = cur / 2;
            n1--;
            n2--;
        }
        while (n1 > -1) {
            int cur = (arr1[n1] - '0') + tmp;
            ans[np++] = cur % 2;
            tmp = cur / 2;
            n1--;
        }
        if (tmp != 0)
            ans[np++] = 1;
        String ret = "";
        for (int i = np - 1; i >= 0; i--)
            ret += ans[i];
        return ret;
    }
}
