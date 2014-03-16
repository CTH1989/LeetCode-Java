public class Solution {
    public double power(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;
        double ret = power(x, n / 2);
        if (n % 2 == 1)
            return ret * ret * x;
        else
            return ret * ret;
    }
    public double pow(double x, int n) {
        if (n < 0)
            return 1.0 / power(x, -n);
        else
            return power(x, n);
    }
}
