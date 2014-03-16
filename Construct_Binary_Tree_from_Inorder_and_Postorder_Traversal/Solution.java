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
    public TreeNode build(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if (il == ir)
            return new TreeNode(inorder[il]);
        int node = postorder[pr], i;
        TreeNode ret = new TreeNode(node);
        for (i = il; i <= ir; i++)
            if (node == inorder[i])
                break;
        if (i == il) {
            ret.right = build(inorder, il + 1, ir, postorder, pl, pr - 1);
        } else if (i == ir) {
            ret.left = build(inorder, il, ir - 1, postorder, pl, pr - 1);
        } else {
            int mid = pl + i - il - 1;
            ret.left = build(inorder, il, i - 1, postorder, pl, mid);
            ret.right = build(inorder, i + 1, ir, postorder, mid + 1, pr - 1);
        }
        return ret;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0)
            return null;
        return build(inorder, 0, len - 1, postorder, 0, len - 1);
    }
}
