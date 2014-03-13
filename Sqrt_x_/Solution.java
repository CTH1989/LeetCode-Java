public class Solution {
    public int sqrt(int x) {
        if (x <= 1) return x;
        int l = 1, r = x, mid = r;
        while (l < r - 1) {
            mid = (l + r) / 2;
            if (x / mid == mid)
                return mid;
            else if (x / mid < mid)
                r = mid;
            else
                l = mid;
        }
        return l;
    }
}
