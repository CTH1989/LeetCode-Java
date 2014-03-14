public class Solution {
    public boolean canJump(int[] A) {
        if (A.length == 0)
            return false;
        int np = 0;
        while (np < A.length) {
            if (A[np] == 0)
                break;
            np += A[np];
        }
        if (np >= A.length - 1)
            return true;
        else
            return false;
    }
}
