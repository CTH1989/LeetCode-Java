public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int minDis = Integer.MAX_VALUE, ans = 0, len = num.length;
        Arrays.sort(num);

        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int tmp = num[i] + num[j] + num[k];
                int dis = tmp - target;
                if (minDis > Math.abs(dis)) {
                    minDis = Math.abs(dis);
                    ans = tmp;
                }
                if (dis == 0) {
                    return ans;
                } else if (dis > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}
