public class Solution {
    public int singleNumber(int[] A) {
        int tmp = 0;
        for (int Ele : A) {
            tmp ^= Ele;
        }
        return tmp;
    }
}
