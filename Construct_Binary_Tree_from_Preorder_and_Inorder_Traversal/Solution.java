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
    public TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl == pr) {
            TreeNode ret = new TreeNode(preorder[pl]);
            return ret;
        }
        TreeNode ret = new TreeNode(preorder[pl]);
        int node = preorder[pl], i;
        for (i = il; i <= ir; i++) {
            if (node == inorder[i])
                break;
        }
        if (i == il) {
            ret.right = build(preorder, pl + 1, pr, inorder, il + 1, ir);
        } else if (i == ir) {
            ret.left = build(preorder, pl + 1, pr, inorder, il, ir - 1);
        } else {
            int mid = pl + i - il;
            ret.left = build(preorder, pl + 1, mid, inorder, il, i - 1);
            ret.right = build(preorder, mid + 1, pr, inorder, i + 1, ir);
        }
        return ret;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0)
            return null;
        return build(preorder, 0, len - 1, inorder, 0, len - 1);
    }
}
