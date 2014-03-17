/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        TreeLinkNode np = root;
        while (np != null) {
            TreeLinkNode pp = null;
            TreeLinkNode next = null;
            while (np != null) {
                if (np.left == null && np.right == null) {
                    np = np.next;
                    continue;
                }
                if (next == null)
                    next = (np.left == null) ? np.right : np.left;
                if (np.left != null) {
                    if (pp != null)
                        pp.next = np.left;
                    pp = np.left;
                }
                if (np.right != null) {
                    if (pp != null)
                        pp.next = np.right;
                    pp = np.right;
                }
                
                np = np.next;
            }
            np = next;
        }
    }
}
