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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        int ret = sum - root.val;
        if (root.left == null && root.right == null) {
            if (ret == 0)
                return true;
            else
                return false;
        } else if (root.left == null) {
            return hasPathSum(root.right, ret);
        } else if (root.left == null) {
            return hasPathSum(root.left, ret);
        } else {
            return hasPathSum(root.left, ret) || hasPathSum(root.right, ret);
        }
    }
}
