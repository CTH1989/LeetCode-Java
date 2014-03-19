public class Solution {
    public void sortColors(int[] A) {
        // http://oj.leetcode.com/discuss/1827/anyone-with-one-pass-and-constant-space-solution
        int i = -1, j = -1, k = -1;
        int len = A.length;
        if (len == 0)
            return ;
        for (int m = 0; m < len; m++) {
            if (A[m] == 0) {
                A[++k] = 2;
                A[++j] = 1;
                A[++i] = 0;
            } else if (A[m] == 1) {
                A[++k] = 2;
                A[++j] = 1;
            } else
                A[++k] = 2;
        }
    }
}
