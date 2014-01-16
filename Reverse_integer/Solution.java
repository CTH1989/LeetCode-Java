public class Solution {
    public int reverse(int x) {
        // Actually, there is no test case in OJ for overflow
        int sign = 1, tmp = 0;
        if (x < 0) {
            sign = -1;
            tmp *= -1;
        }
        while (x != 0) {
            tmp = tmp * 10 + x % 10;
            x /= 10;
        }
        return tmp;
    }
}
