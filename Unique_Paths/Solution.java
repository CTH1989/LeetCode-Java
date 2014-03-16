public class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    public int combination(int m, int n) {
        if (n > m / 2)
            return combination(m, m - n);
        int result = 1;
        for (int i = 1; i <= n; i++) {
            int mul = m - i + 1;
            int div = i;
            int g = gcd(mul, div);
            mul /= g;
            div /= g;
            result /= div; // divided first
            result *= mul;
        }
        return result;
    }
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return combination(m + n - 2, n - 1);
    }
}
