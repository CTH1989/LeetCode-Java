public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length, i, j, np = 0;
        for (i = 0; i < len; ) {
            for (j = i + 1; j < len; j++) {
                if (A[i] != A[j])
                    break;
            }
            A[np++] = A[i];
            i = j;
        }
        return np;
    }
}
