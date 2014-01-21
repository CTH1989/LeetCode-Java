public class Solution {
    public int removeElement(int[] A, int elem) {
        int np = 0, len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] != elem) {
                A[np++] = A[i];
            }
        }
        return np;
    }
}
