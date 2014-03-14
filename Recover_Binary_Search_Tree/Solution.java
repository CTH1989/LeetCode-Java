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
    public void recoverTree(TreeNode root) {
        TreeNode pre = null, n1 = null, n2 = null;
        if (root == null)
            return ;
        TreeNode np = root, pp = null;
        while (np != null) {
            if (np.left == null) {
                if (pre == null)
                    pre = np;
                else {
                    if (pre.val > np.val) {
                        if (n1 == null)
                            n1 = pre;
                        n2 = np;
                    }
                    pre = np;
                }
                np = np.right;
            } else {
                pp = np.left;
                while (pp.right != null && pp.right != np)
                    pp = pp.right;
                if (pp.right == null) {
                    pp.right = np;
                    np = np.left;
                } else {
                    pp.right = null;
                    if (pre == null)
                        pre = np;
                    else {
                        if (pre.val > np.val) {
                            if (n1 == null)
                                n1 = pre;
                            n2 = np;
                        }
                        pre = np;
                    }
                    np = np.right;
                }
            }
        }
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
