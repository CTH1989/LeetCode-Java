/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> build(int[] arr, int l, int r) {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if (l > r) {
            ret.add(null);
            return ret;
        }
        if (l == r) {
            ret.add(new TreeNode(arr[l]));
            return ret;
        }
        for (int i = l; i <= r; i++) {
            ArrayList<TreeNode> left = build(arr, l, i - 1);
            ArrayList<TreeNode> right = build(arr, i + 1, r);
            if (left.size() != 0 && right.size() != 0) {
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode np = new TreeNode(arr[i]);
                        np.left = left.get(j);
                        np.right = right.get(k);
                        ret.add(np);
                    }
                }
            } else if (left.size() == 0) {
                for (int j = 0; j < right.size(); j++) {
                    TreeNode np = new TreeNode(arr[i]);
                    np.right = right.get(j);
                    ret.add(np);
                }
            } else if (right.size() == 0) {
                for (int j = 0; j < left.size(); j++) {
                    TreeNode np = new TreeNode(arr[i]);
                    np.left = left.get(j);
                    ret.add(np);
                }
            }
        }
        return ret;
    }
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> ans = null;
        int[] arr = new int[n];
        for (int i = 1; i<= n; i ++)
            arr[i - 1] = i;
        ans = build(arr, 0, n - 1);
        return ans;
    }
}
