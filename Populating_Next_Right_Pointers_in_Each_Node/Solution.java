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
        if (root == null)
            return ;
        Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            TreeLinkNode pp, np;
            pp = que.poll();
            np = pp;
            if (np.left == null)
                break;
            np.left.next = np.right;
            que.offer(np.left);
            que.offer(np.right);
            for (int i = 1; i < len; i++) {
                np = que.poll();
                np.left.next = np.right;
                pp.right.next = np.left;
                pp = np;
                que.offer(np.left);
                que.offer(np.right);
            }
        }
    }
}
