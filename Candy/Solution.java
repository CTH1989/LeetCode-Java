public class Solution {
    public int candy(int[] ratings) {
        int min = 0, i, k;
        int[] assign = new int[ratings.length];
        assign[0] = 1;
        for (i = 1; i < ratings.length; i ++) {
            if (ratings[i] > ratings[i - 1]) {
                assign[i] = assign[i - 1] + 1;
            } else assign[i] = 1;
        }
        for (i = ratings.length - 2; i >= 0; i --) {
            if (ratings[i] > ratings[i + 1] && assign[i] <= assign[i + 1]) {
                assign[i] = assign[i + 1] + 1;
            }
        }
        int ans = 0;
        for (i = 0; i < ratings.length; i ++) {
            ans += assign[i];
        }
        return ans;
    }
}
