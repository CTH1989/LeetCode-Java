public class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 0, flag = 1;
        long a, b, c;
        if (dividend < 0) flag *= -1;
        if (divisor < 0) flag *= -1;
        
        a = Math.abs((long) dividend);
        b = Math.abs((long) divisor);
        c = 1;
        
        while (a > b) {
            b = b << 1;
            c = c << 1;
        }
            
        while (a >= Math.abs((long) divisor)) {
            while (a >= b) {
                a-= b;
                ans += (int) c;
            }
            b = b >> 1;
            c = c >>1;
        }
        
        return flag * ans;
    }
}
