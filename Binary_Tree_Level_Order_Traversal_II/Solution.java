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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return ans;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (!que.isEmpty()) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            int len = que.size();
            for (int  i = 0; i < len; i++) {
                TreeNode np = que.poll();
                ret.add(np.val);
                if (np.left != null)
                    que.add(np.left);
                if (np.right != null)
                    que.add(np.right);
            }
            ans.add(ret);
        }
        Collections.reverse(ans);
        return ans;
    }
}
