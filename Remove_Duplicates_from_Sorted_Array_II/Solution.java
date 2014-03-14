public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len == 0)
            return 0;
        int np = 0, ans = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] != A[np]) {
                int count = i - np;
                if (count > 1) {
                    A[ans++] = A[np];
                    A[ans++] = A[np];
                }
                else
                    A[ans++] = A[np];
                np = i;
            }
        }
        if (len - 1 != np) {
            int count = len - np;
            if (count > 1) {
                A[ans++] = A[np];
                A[ans++] = A[np];
            } else 
                A[ans++] = A[np];
        } else
            A[ans++] = A[np];
        for (int i = ans; i < len; i++)
            A[i] = 0;
        return ans;
    }
}
