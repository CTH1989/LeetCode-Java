public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        int mask = 1;
        for (int i = 0; i < n; i++) {
            mask = 1 << i;
            int len = ans.size();
            for (int j = len - 1; j >= 0; j--)
                ans.add(ans.get(j) | mask);
            
        }
        return ans;
    }
}
