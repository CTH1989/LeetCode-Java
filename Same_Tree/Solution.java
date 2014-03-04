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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        boolean flag1 = false, flag2 = false;
        flag1 = isSameTree(p.left, q.left);
        flag2 = isSameTree(p.right, q.right);
        if (flag1 && flag2)
            return true;
        else
            return false;
    }
}
