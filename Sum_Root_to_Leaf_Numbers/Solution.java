/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int ans;
    public void dfs(TreeNode node, int sum) {
        int ret = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += ret;
        } else if (node.left == null) {
            dfs(node.right, ret);
        } else if (node.right == null) {
            dfs(node.left, ret);
        } else {
            dfs(node.right, ret);
            dfs(node.left, ret);
        }
    }
    public int sumNumbers(TreeNode root) {
        ans = 0;
        if (root == null)
            return ans;
        dfs(root, 0);
        return ans;
    }
}
