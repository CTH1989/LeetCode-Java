public class Solution {
    public int singleNumber(int[] A) {
        // http://oj.leetcode.com/discuss/857/constant-space-solution
        int one = 0, two = 0, three = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            two |= one & A[i];
            one ^= A[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
