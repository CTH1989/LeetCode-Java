public class Solution {
    public int maxArea(int[] height) {
        int ans = -1;
        int head = 0, tail = height.length - 1;
        while (head < tail) {
            ans = Math.max(ans, Math.min(height[head], height[tail]) * (tail - head));
            if (height[head] < height[tail]) {
                head ++;
            } else {
                tail --;
            }
        }
        return ans;
    }
}
