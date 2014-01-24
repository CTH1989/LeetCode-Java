public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length, i;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (i = 0; i < len; i ++) {
            if (A[i] > 0) map.put(A[i], true);
        }
        for (i = 1; i <= len; i ++) {
            if (!map.containsKey(i)) break;
        }
        return i;
    }
}
