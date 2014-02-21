/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (points.length < 2)
            return points.length;
        int len = points.length, ans = 2;
        double inf = Double.MAX_VALUE;
        double[] k = new double[len];
        for (int i = 0; i < len - 1; i++) {
            int num = 0, ret = 1;
            for (int j = i + 1; j < len; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        ret++;
                        continue;
                    }
                    k[num++] = inf;
                } else {
                    k[num++] = (1.0 * (points[i].y - points[j].y))
                            / (1.0 * (points[i].x - points[j].x));
                }
            }
            Arrays.sort(k, 0, num);

            int tmp = 0, max = 0;
            double flag = k[0];
            for (int j = 0; j < num; j++) {
                if (k[j] == flag)
                    tmp ++;
                else {
                    if (tmp > max) max = tmp;
                    flag = k[j];
                    tmp = 1;
                }
            }
            if (tmp > max) max = tmp;
            ret += max;

            if (ret > ans)
                ans = ret;
        }
        return ans;
    }
}
