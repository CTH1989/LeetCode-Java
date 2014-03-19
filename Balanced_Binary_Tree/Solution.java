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
    public int check(TreeNode node) {
        if (node == null)
            return 0;
        int left = check(node.left);
        int right = check(node.right);
        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else
            return -1;
    }
    public boolean isBalanced(TreeNode root) {
        if (check(root) == -1)
            return false;
        else
            return true;
    }
}
