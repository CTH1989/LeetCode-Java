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
    public boolean trav(TreeNode node, int min, int max) {
        if (node == null)
            return true;
        if (node.left != null && node.right != null) {
            if (node.left.val < node.val && node.val < node.right.val && min < node.left.val && node.right.val < max)
                return trav(node.left, min, node.val) && trav(node.right, node.val, max);
            else
                return false;
        } else if (node.left != null) {
            if (node.left.val < node.val && min < node.left.val)
                return trav(node.left, min, node.val);
            else
                return false;
        } else if (node.right != null) {
            if (node.val < node.right.val && node.right.val < max)
                return trav(node.right, node.val, max);
            else
                return false;
        } else {
            return true;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return trav(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
