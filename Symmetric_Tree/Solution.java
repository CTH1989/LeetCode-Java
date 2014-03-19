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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (!que.isEmpty()) {
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            int len = que.size();
            for (int i = 0; i < len; i++)
                list.add(que.poll());
            for (int i = 0; i < len / 2; i++) {
                TreeNode a = list.get(i);
                TreeNode b = list.get(len - 1 - i);
                if (a != null && b != null) {
                    if (a.val != b.val)
                        return false;
                } else if (a != null)
                    return false;
                else if (b != null)
                    return false;
                else
                    continue;
            }
            for (int i = 0; i < len; i++) {
                if (list.get(i) != null) {
                    que.add(list.get(i).left);
                    que.add(list.get(i).right);
                }
            }
        }
        return true;
    }
}
