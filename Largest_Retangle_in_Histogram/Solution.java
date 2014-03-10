public class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        if (len == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int ans = 0;
        while (i < len) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.add(i++);
            } else {
                int np = stack.pop();
                int ret = height[np] * (stack.isEmpty()? i : i - stack.peek() - 1);
                if (ret > ans)
                    ans = ret;
            }
        }
        while (!stack.isEmpty()) {
            int np = stack.pop();
            int ret = height[np] * (stack.isEmpty()? i : i - stack.peek() - 1);
            if (ret > ans)
                ans = ret;
        }
        return ans;
    }
}
