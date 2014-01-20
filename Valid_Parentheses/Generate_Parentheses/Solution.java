public class Solution {
    public void recursive(int n, String str, int left, int right, ArrayList<String> ret) {
        if (left == n && right == n) {
            ret.add(str);
        } else {
            if (left == right) {
                recursive(n, str + "(", left + 1, right, ret);
            } else if (right < left) {
                if (left < n) recursive(n, str + "(", left + 1, right, ret);
                recursive(n, str + ")", left, right + 1, ret);
            }
        }
    }
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        recursive(n, "", 0, 0, ans);
        Collections.sort(ans);
        return ans;
    }
}
