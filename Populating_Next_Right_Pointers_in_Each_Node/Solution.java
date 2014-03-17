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
        if (root == null || root.left == null)
            return ;
        TreeLinkNode pp = null, np = root;
        TreeLinkNode start = root;
        while (np != null) {
            if (pp != null)
                pp.right.next = np.left;
            if (np.left == null)
                break;
            np.left.next = np.right;
            pp = np;
            np = np.next;
            if (np == null) {
                np = start.left;
                start = np;
                pp = null;
            }
        }
    }
}
