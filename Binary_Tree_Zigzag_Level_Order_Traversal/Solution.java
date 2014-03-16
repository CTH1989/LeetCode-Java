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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return ans;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        boolean flag = true;
        while (!que.isEmpty()) {
            int num = que.size();
            ArrayList<Integer> ret = new ArrayList<Integer>();
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            while (num != 0) {
                TreeNode np = que.poll();
                ret.add(np.val);
                if (np.left != null)
                    list.add(np.left);
                if (np.right != null)
                    list.add(np.right);
                num--;
            }
            if (!flag)
                Collections.reverse(ret);
            flag = !flag;
            ans.add(ret);
            que.addAll(list);
        }
        return ans;
    }
}
