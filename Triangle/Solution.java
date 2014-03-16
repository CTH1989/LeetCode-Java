public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int height = triangle.size();
        if (height == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < triangle.get(height - 1).size(); i ++) {
            int np = triangle.get(height - 1).get(i);
            ans = Math.min(ans, np);
            list.add(np);
        }
        for (int i = height - 2; i >= 0; i--) {
            ans = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                int tmp = triangle.get(i).get(j) + Math.min(list.get(j), list.get(j + 1));
                list.set(j, tmp);
                ans = Math.min(ans, tmp);
            }
        }
        return ans;
    }
}
