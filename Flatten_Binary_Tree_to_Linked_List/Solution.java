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
    public TreeNode flat(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            TreeNode tail = flat(root.right);
            return tail;
        } else if (root.right == null) {
            TreeNode tail = flat(root.left);
            root.right = root.left;
            root.left = null;
            return tail;
        } else {
            TreeNode mid = flat(root.left);
            TreeNode tail = flat(root.right);
            mid.right = root.right;
            root.right = root.left;
            root.left = null;
            return tail;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null)
            return ;
        flat(root);
    }
}
