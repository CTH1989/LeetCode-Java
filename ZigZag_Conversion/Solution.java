public class Solution {
    public String convert(String s, int nRows) {
        int length = s.length();
        char[] sArr = s.toCharArray();
        char[] tArr = new char[length];
        if (nRows == 1)
            return s;
        int pp, np, len, pt;
        len = (nRows - 2) * 2 + 1;

        pt = 0;
        for (int i = 0; i < nRows; i++) {
            if (i < length) {
                tArr[pt++] = sArr[i];
            } else {
                break;
            }
            if (i == 0 || i == nRows - 1) {
                np = i + len + 1;
                while (np < length) {
                    tArr[pt++] = sArr[np];
                    np += len + 1;
                }
            } else {
                np = i + len + 1;
                pp = i + (len - 2 * i) + 1;
                while (pp < length) {
                    tArr[pt++] = sArr[pp];
                    if (np < length) {
                        tArr[pt++] = sArr[np];
                    }
                    np += len + 1;
                    pp += len + 1;
                }
            }
        }
        return new String(tArr);
    }
}
