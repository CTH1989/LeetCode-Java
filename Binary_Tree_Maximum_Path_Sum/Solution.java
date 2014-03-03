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
    public int max = Integer.MIN_VALUE;
    public int recur(TreeNode node) {
        if (node == null)
            return 0;
        int left = 0, right = 0;
        if (node.left != null)
            left = Math.max(0, recur(node.left));
        if (node.right != null)
            right = Math.max(0, recur(node.right));
        int tmp = Math.max(left, right);
        if ((node.val + left + right) > max)
            max = (node.val + left + right);
        return node.val + tmp;
    }
    public int maxPathSum(TreeNode root) {
        recur(root);
        return max;
    }
}
